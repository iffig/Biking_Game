package com.csciOOD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.csciOOD.Game;
import com.csciOOD.Menu;

public class Screen extends JFrame {
    // Settings for window
    private JLayeredPane basePane = new JLayeredPane();
    private Container contentPane = getContentPane();
    // Top-level object responsible for game state and rendering
    private Game content = new Game();
    // Pause, menu, high-schores
    private Menu menu = new Menu(contentPane);
    // Area for score/timer/heath etc
    JPanel headerPanel = new JPanel();

    // JFrame is our top-level container, inside of which we render panes
    public Screen(){
        // Not TOTALLY sure how much this does for us...
        super("Colorado Biking Game");
        setSize(800, 800);
        // Make sure we can repond to keyboard input
        bindKeys();
        // Settings for window
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 800));

        // Establish base Layered Pane
        add(basePane, BorderLayout.CENTER);
        basePane.setBounds(0, 0, 800, 800);

        // Add panes that we'll be using (name, z-index)
        basePane.add(headerPanel, new Integer(1));
        basePane.add(content, new Integer(0));
        basePane.add(menu, new Integer(2));

        // Start our gameLoop from our Main Game object
        Thread mainThread = new Thread(content);
        mainThread.start();
    }

    public static void main(String[] args) {
        Screen gameScreen = new Screen();
        gameScreen.pack();
        gameScreen.setVisible(true);
    }

    private void bindKeys(){
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    pauseGame();
                }
                return false;
            }
        });
    }

    private void pauseGame() {
        content.pause();
        menu.toggle();
    }
}
