package com.csciOOD;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.csciOOD.Screen;

public class Menu extends JPanel implements ActionListener {
    private Container context;
    private Game gameInstance;
    private int height = 500;
    private int width = 500;
    private int x = 150;
    private int y = 150;

    private boolean isHidden = true;

    public Menu(Game game) {
        setBackground(new Color(80, 80, 240, 200));
        setBounds(x, y, width, height);

        JLabel placeholderText = new JLabel("Game is Paused. Hit Escape again to resume", SwingConstants.CENTER);
        add(placeholderText);

        JButton saveButton = new JButton("Save Game");
        saveButton.setActionCommand("save");
        saveButton.addActionListener(this);
        add(saveButton);

        JButton gameEndButton = new JButton("End Game (without saving)");
        gameEndButton.setActionCommand("end");
        gameEndButton.addActionListener(this);
        add(gameEndButton);


        setOpaque(true);
        setLayout(new GridLayout(3, 1));
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

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "save":
                System.out.println("The game was SAVED!");
                break;
            case "end":
                System.exit(0);
        }
    }
}
