package com.csciOOD;

import javax.swing.*;
import java.awt.*;

import com.csciOOD.BouncingObject;

public class Game extends JPanel implements Runnable {
    //Can i make this Public?
    public BouncingObject demoRect = new BouncingObject();
    float interpolation;

    // Top-level state for control flow
    private boolean gameRunning = true;
    private boolean isPaused = false;

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


    // Any methods that change game state in here
    public void updateGame() {
        demoRect.update();
    }

    public void paintComponent(Graphics g){
        // This is where we invoke the interpolation values to blend animation
        g.drawRect((int) demoRect.x, (int) demoRect.y, demoRect.width, demoRect.height);
        g.setColor(Color.PINK);
        g.fillRect((int) demoRect.x, (int) demoRect.y, demoRect.width, demoRect.height);
    }
}
