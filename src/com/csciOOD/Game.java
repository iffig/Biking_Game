package com.csciOOD;

import javax.swing.*;
import com.csciOOD.BouncingObject;

import java.awt.*;

public class Game extends JPanel implements Runnable {
    private BouncingObject demoRect = new BouncingObject();
    float interpolation;

//    public Game(Container contentPane) {
//        demoRect = new BouncingObject(contentPane);
//
//
//    }
//
//    public void updateGame(){
//        demoRect.update();
//    }
//
//    public void reRender(){
//        demoRect.repaint();
//    }

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
        System.out.println("about to run...");
        while (gameRunning) {
            double now = System.nanoTime();
//            System.out.println("inside while");
//            if (!isPaused) {
                double deltaUpdate = now - lastUpdateTime;
                double deltaRender = now - lastRenderTime;

//                while(deltaUpdate > updateInterval) {
//                    lastUpdateTime += updateInterval;
                    updateGame();
//                }

                interpolation = Math.min(1.0f, (float) (deltaUpdate / updateInterval));

                repaint();

                lastRenderTime = now;

//                while (deltaRender < renderInterval && deltaUpdate < updateInterval) {
//                    Thread.yield();
//                }
//            }
        }
    }

    // Any methods that change game state in here
    public void updateGame() {
//        System.out.println("about to update");
        demoRect.update();
//        System.out.println("updated");
    }

    public void paintComponent(Graphics g){
//        System.out.println("about to paint");

        System.out.println("x val " + demoRect.x);

        // This is where we invoke the interpolation values to blend animation
        g.drawRect((int) demoRect.x, (int) demoRect.y, demoRect.width, demoRect.height);
        g.setColor(Color.RED);
        g.fillRect((int) demoRect.x, (int) demoRect.y, demoRect.width, demoRect.height);
//        System.out.println("painted!");
    }
}
