package com.csciOOD;

import javax.swing.*;
import java.awt.*;

public class Sprite extends JPanel {

    // "State" Flags
    public boolean isNaturalSlow = false;
    public boolean isSpeedingUp = false;
    public boolean isSlowingDown = false;

    // Rates of Movement
    public float xVelocity = 6;
    public float yVelocity = 2;

    // isNaturalSlow
    public double naturalSlowSpeed = 0.75;

    // isSpeedingUp
    public float speedUp = xVelocity/2;


    //isSlowingDown
    public float slowSpeed = (xVelocity/2);

    // Starting Position
    public float x = 50;
    public float y = 600;
    public float start_position = 50;
    public float ground_height = 600;
    public float right_boundary = 750;


    // Character Specs
    public int width = 50;
    public int height = 50;
    public int original_height = 50;
    public int duck_height = (original_height/2);

    // Jump Specs
    public float jump_height = 400;

    public Sprite(){}


    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, width, height);
    }

    // Movement Functionality

    public void jump(){
        while(y > jump_height)
            y -=yVelocity;
    }

    public void duck(){
        height = duck_height;
        y = ground_height + duck_height;
    }

    public void unDuck(){
        y = ground_height;
        height = original_height;
    }

    public void drawSprite(Graphics g){
        g.setColor(Color.GRAY);
        g.drawRect((int) x, (int) y, width, height);
        g.setColor(Color.GRAY);
        g.fillRect((int) x, (int) y, width, height);

    }


    public void update() {
        //Boundaries
        if (x > right_boundary) {
            x = right_boundary;
        }
        if (x < start_position) {
            x = start_position;
        }

        //Falling Motion
        if (y < ground_height) {
            y += yVelocity;
        }

        if (isNaturalSlow) {
            if (x > start_position) {
                x -= naturalSlowSpeed;
            }
            if (x < start_position) {
                x = start_position;
            }
        }

        if (isSpeedingUp) {

            x += speedUp;
        }

        if (isSlowingDown) {
            x -= slowSpeed;
        }

    }

}