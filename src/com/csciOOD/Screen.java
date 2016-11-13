package com.csciOOD;

import javax.swing.*;
import java.awt.*;
import com.csciOOD.Game;
import com.csciOOD.Menu;

public class Screen extends JFrame {
    // Settings for window
    Container contentPane = getContentPane();
    // Internal class to render to screen (constraint of JFrame -> JPanel)
    private MainPannel content = new MainPannel();
    // Pause, menu, high-schores
    private Menu menu = new Menu(contentPane);
    // Top-level object responsible for game state
    private Game gameInstance = new Game(contentPane);

    // JFrame is our top-level container, inside of which we render panes
    public Screen(){
        // Not TOTALLY sure how much this does for us...
        super("Colorado Biking Game");
        System.out.println("ad");
        // Settings for window
        contentPane.setLayout(new BorderLayout());
        // Upper pane for time and score and what not
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(1,5));
        // Add initial panes
        contentPane.add(headerPanel, BorderLayout.NORTH);
        contentPane.add(content, BorderLayout.CENTER);

        setSize(800, 800);
        System.out.println("Constructed...");
        // Start our gameLoop
        Thread mainThread = new Thread(content);
        mainThread.start();
    }

    public static void main(String[] args) {
        System.out.println("ojayy");
        Screen gameScreen = new Screen();
        System.out.println("Should have new screen?");
        gameScreen.setVisible(true);
    }

    private class MainPannel extends JPanel implements Runnable {
        float interpolation;
        // Top-level state for control flow
        private boolean gameRunning = false;
        private boolean isPaused = false;

        public MainPannel() {}

        public void run(){
            System.out.println("run engaged!");
            gameLoop();
        }

        // Any methods that change game state in here
        public void update() {
            gameInstance.updateGame();
        }

        // TODO: mitigate death spiral and lag scnearios
        private void gameLoop() {

            // Shoot for the Stars!
            double fpsLimit = 120;
            double updateInterval = 1000000000 / fpsLimit; // Should / could be set to something else. Lower? higher?
            double renderInterval = 1000000000 / fpsLimit;
            double lastUpdateTime = System.nanoTime();
            double lastRenderTime = System.nanoTime();

            while (gameRunning) {
                double now = System.nanoTime();

                if (!isPaused) {
                    double deltaUpdate = now - lastUpdateTime;
                    double deltaRender = now - lastRenderTime;

                    while(deltaUpdate > updateInterval) {
                        lastUpdateTime += updateInterval;
                        update();
                    }

                    float interpolation = Math.min(1.0f, (float) (deltaUpdate / updateInterval));

                    drawGame(interpolation);

                    lastRenderTime = now;

                    while (deltaRender < renderInterval && deltaUpdate < updateInterval) {
                        Thread.yield();
                    }
                }
            }
        }

        private void drawGame(float interp){
            interpolation = interp;
            gameInstance.reRender();
        }
    }
}
