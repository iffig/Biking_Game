package com.csciOOD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.csciOOD.Game;

public class Screen extends JFrame implements ActionListener {
    public Screen(){}

    // For now we can just run our game through this class
    // TODO: how to package JARs and where the main() should live
    public static void main(String[] args) {
        Screen gameInstance = new Screen();
        gameInstance.setVisible(true);
    }

    // User input affects the game through this method
    public void actionPerformed(ActionEvent e) {

    }

}
