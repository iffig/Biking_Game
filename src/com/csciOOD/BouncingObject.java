package com.csciOOD;
import com.csciOOD.Game;
import java.awt.*;

public class BouncingObject extends Game {
    private float x = 0;
    private float y = 0;
    private float lastX = 0;
    private float lastY = 0;
    private int width = 42;
    private int height = 42;
    private int speed = 20;
    private int xVelocity = (int) Math.random() * speed;
    private int yVelocity = (int) Math.random() * speed;

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
        lastX = x;
        lastY = y;
        x += xVelocity;
        y += yVelocity;

        // If we hit a wall...
        if (wallWasHit()) {
            // reverse direction
            xVelocity = -xVelocity;
        }

        if (ceilOrFloorWasHit()) {
            yVelocity = -yVelocity;
        }

    }

    // This is where you can do your sprite animations
    protected void paintComponent(Graphics g){
        // Not using interpolation... casting like a mofo, because this is just
        // for illustrative purposes.
        g.drawRect((int) x, (int) y, width, height);
        g.setColor(Color.RED);
        g.fillOval((int) x, (int) y, width, height);
    }
}
