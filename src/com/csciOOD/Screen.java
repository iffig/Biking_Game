package com.csciOOD;

import javax.swing.*;
import java.awt.*;
import com.csciOOD.Game;
import com.csciOOD.Menu;

public class Screen extends JFrame {
    // Settings for window
    Container contentPane = getContentPane();
    // Top-level object responsible for game state and rendering
    private Game content = new Game();
    // Pause, menu, high-schores
    private Menu menu = new Menu(contentPane);

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
        // Start our gameLoop from our Main Game object
        Thread mainThread = new Thread(content);
        mainThread.start();
    }

    public static void main(String[] args) {
        System.out.println("ojayy");
        Screen gameScreen = new Screen();
        System.out.println("Should have new screen?");
        gameScreen.setVisible(true);
    }
}
