package com.csciOOD;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Game extends JPanel implements Runnable {

    public Sprite sprite = new Sprite();
    public DamageTracker damage = new DamageTracker();
    public ScoreTracker score = new ScoreTracker();
    public EndScreen endScreen = new EndScreen();

    //colors
    Color skyColor = new Color(153, 255, 255);
    Color grassColor = new Color(153, 255, 153);
    Color trackColor = new Color(213, 190, 172);

    float interpolation;

    // Top-level state for control flow
    private boolean gameRunning = true;
    private boolean isPaused = false;
    // Collision state boolean variable
    private boolean isCollision = false;
    // Boolean to say game is over
    public boolean gameOver = false;

    JPanel panel = new JPanel();

    public Game() {
        setOpaque(true);
        setBounds(0,0,800,800);
    }

    public void pause() {
        isPaused = !isPaused;
    }

    public void run(){
        gameLoop();
    }

    // TODO: mitigate death spiral and lag scenarios
    // CPU saver and smoothing tips inspired by http://www.java-gaming.org/index.php?PHPSESSID=0l3msuh17hfkam8a8kbr904ck1&/topic,24220.0
    private void gameLoop() {
        double hertz = 30.0;
        double updateInterval = 1000000000 / hertz;
        double lastUpdateTime = System.nanoTime();

        double fpsLimit = 60;
        double renderInterval = 1000000000 / fpsLimit;
        double lastRenderTime = System.nanoTime();

        int updatesInRenderLimit = 5;

        while (gameRunning) {
            if (!isPaused) {
                double now = System.nanoTime();
                int updateCount = 0;

                while(now - lastUpdateTime > updateInterval && updateCount < updatesInRenderLimit) {
                    lastUpdateTime += updateInterval;
                    updateCount++;
                    updateGame();
                }

                repaint();

                //Yield until it has been at least the target time between renders. This saves the CPU from hogging.
                while ( now - lastRenderTime < renderInterval && now - lastUpdateTime < updateInterval) {
                    Thread.yield();

                    try {Thread.sleep(1);} catch(Exception e) {}

                    now = System.nanoTime();
                }
            } else {
                lastUpdateTime = System.nanoTime();
                lastRenderTime = System.nanoTime();
            }

            if(gameOver){
                repaint();
            }
        }
    }

    public boolean obstacleOnScreen = false;

    ObstacleFactory obstFact = new ObstacleFactory();
    Obstacle obst;

    // Any methods that change game state in here
    public void updateGame() {

        sprite.update();

        if (isCollision) {
            // If a collision has happened. Do this code.
            obst.setisCollided(true);
            if (obst.getisGood()){
                damage.increment(obst.getpointValue());
                score.increment(obst.getpointValue());
            }
            else if (!obst.getisGood()){
                damage.decrement(obst.getpointValue());
                score.decrement(obst.getpointValue());
            }
        }
        if(damage.getIsGameOver()){
            gameOver = true;
            obstacleOnScreen = true;
        }

        // Obstacle Updates
        if(obstacleOnScreen == false ){
            obst = obstFact.getObstacle();
            obstacleOnScreen = true;
        }
        if(obst.getIsOnScreen() == true){
            obst.update();
        }
        if(obst.getIsOnScreen() == false){
            obstacleOnScreen = false;
        }

        isCollision = checkCollision();

    }

    public void paintComponent(Graphics g){
        g.clearRect(0,0,getWidth(), getHeight());
        g.setColor(skyColor);
        g.fillRect(0, 0, 800, 500);
        g.setColor(grassColor);
        g.fillRect(0, 500, 800, 300);
        g.setColor(trackColor);
        g.fillRect(0, 550, 800, 150);


        if(gameOver){
            endScreen.display(g,score.getScore());
        }
        else{
            score.painting(g);
            damage.painting(g);
            sprite.drawSprite(g);
            obst.create(g);
        }
    }

    public boolean checkCollision() {
        return obst.getBounds().intersects(sprite.getBounds());
    }
}