package com.csciOOD;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import com.csciOOD.Screen;

public class Menu extends JPanel {
    private Container context;
    private int height = 700;
    private int width = 700;
    private int x = 50;
    private int y = 50;

    private boolean isHidden = true;

    public Menu() {
        setBackground(new Color(80, 80, 240, 200));
        setBounds(x, y, width, height);

        // TODO: this needs to be more that just text...
        JLabel placeholderText = new JLabel("Game is Paused. Welcome to the Game Menu!!!");
        add(placeholderText);

        setOpaque(true);
        setVisible(false);
    }

    public void toggle(){
        if (isHidden) {
            setVisible(true);
        } else {
            setVisible(false);
        }

        isHidden = !isHidden;
    }
}
