package com.csciOOD;

import javax.swing.*;
import java.awt.*;

import com.csciOOD.BouncingObject;

public class Game extends JPanel implements Runnable {
    private BouncingObject demoRect = new BouncingObject();
    float interpolation;

    // Top-level state for control flow
    private boolean gameRunning = true;
    private boolean isPaused = false;

    public Game() {}

    public void run(){
        System.out.println("run engaged!");
        gameLoop();
    }

    // TODO: mitigate death spiral and lag scenarios
    private void gameLoop() {
        System.out.println("Game loop");
        // Shoot for the Stars!
        double fpsLimit = 120;
        double updateInterval = 1000000000 / fpsLimit; // Should / could be set to something else. Lower? higher?
        double renderInterval = 1000000000 / fpsLimit;
        double lastUpdateTime = System.nanoTime();
        double lastRenderTime = System.nanoTime();

        while (gameRunning) {
            double now = System.nanoTime();
            if (!isPaused) {

                while(now - lastUpdateTime > updateInterval) {
                    lastUpdateTime += updateInterval;
                    updateGame();
                }

                interpolation = Math.min(1.0f, (float) (now - lastUpdateTime / updateInterval));
                System.out.println("aobut to repaint!!");
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
        g.setColor(Color.RED);
        g.fillRect((int) demoRect.x, (int) demoRect.y, demoRect.width, demoRect.height);
    }
}
