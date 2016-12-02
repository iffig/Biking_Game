package com.csciOOD;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Game extends JPanel implements Runnable {

    public Sprite sprite = new Sprite();


    float interpolation;

    // Top-level state for control flow
    private boolean gameRunning = true;
    private boolean isPaused = false;
    // Collision state boolean variable
    private boolean isCollision = false;

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
    private void gameLoop() {
        // Shoot for the Stars!
        double fpsLimit = 120;
        double updateInterval = 1000000000 / fpsLimit; // Should / could be set to something else. Lower? higher?
        double lastUpdateTime = System.nanoTime();

        while (gameRunning) {
            double now = System.nanoTime();
            if (!isPaused) {

                while(now - lastUpdateTime > updateInterval) {
                    lastUpdateTime += updateInterval;
                    updateGame();
                }

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
        if (isCollision) {
            // If a collision has happened. Do this code.
            obst.setisCollided(true);
        }

        isCollision = checkCollision();
    }

    public void paintComponent(Graphics g){
        g.clearRect(0,0,getWidth(), getHeight() );
        sprite.drawSprite(g);
        obst.create(g);

    }

    public boolean checkCollision() {
        return obst.getBounds().intersects(sprite.getBounds());
    }
}