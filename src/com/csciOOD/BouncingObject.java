package com.csciOOD;
import com.csciOOD.Game;

import javax.swing.*;
import java.awt.*;

public class BouncingObject extends JPanel {
    public float x = 10;
    public float y = 10;
    public int width = 42;
    public int height = 42;
    public int speed = 20;
    public int xVelocity = 1;
    public int yVelocity = 1;

    public BouncingObject(){}

    private boolean wallWasHit(){
        boolean leftWallHit = x + width / 2 >= getWidth();
        boolean rightWallHit = x - width / 2 <= 0;

        return leftWallHit || rightWallHit;
    }

    private boolean ceilOrFloorWasHit(){
        boolean ceilingHit = y + height / 2 >= getHeight();
        boolean floorHit = y - height / 2 <= 0;

        return ceilingHit || floorHit;
    }

    public void update(){
        x += xVelocity;
        y += yVelocity;
        System.out.println("x val " + xVelocity);
        // If we hit a wall...
        if (wallWasHit()) {
            // reverse direction
            xVelocity = -xVelocity;
        }

        if (ceilOrFloorWasHit()) {
            yVelocity = -yVelocity;
        }

    }
}
