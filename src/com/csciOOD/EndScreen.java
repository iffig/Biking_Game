package com.csciOOD;

import java.awt.*;

public class EndScreen {

    // Bounds

    int x = 200;
    int y = 300;
    int width = 350;
    int height = 150;
    Color MenuColor = new Color(0, 153, 153);
    public void display(Graphics g, int _score){
        g.setColor(Color.WHITE);
        g.fillRoundRect(x, y, width, height, 10, 10);
        g.setColor(MenuColor);
        g.fillRoundRect(x+10, y+10, width-20, height-20, 10, 10);
        g.setColor(Color.BLACK);
        g.drawString("Game Over", 340, 350);
        g.drawString("Your Score: ", 325, 400);
        g.drawString((Integer.toString(_score)),400, 400);

        //Enter Player Name

    }
}
