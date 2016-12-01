package com.csciOOD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;

import java.awt.event.ActionListener;
import com.csciOOD.Screen;

public class Tracker extends JPanel {
    public static int score;
    private String playerName;
    public long time;
    public static int damagePoints;

    private Container context;
    private int height = 50;
    private int width = 100;
    private int x = 50;
    private int y = 50;

    public Tracker(Container contentPane) {
        setBackground(new Color(166, 240, 69, 122));
        setBounds(x, y, width, height);

        // TODO: this needs to be more that just text...
        JLabel placeholderText = new JLabel("Game is Paused. Welcome to the Game Menu!!!");
        add(placeholderText);

        setOpaque(true);
        setVisible(false);
    }


}