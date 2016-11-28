package com.csciOOD;

import java.awt.*;

public class Frog implements Obstacle{


    float x = start_position;
    float y = ground_height;

    //To detect Point values
    boolean isGoodObject = false;
    int pointValue = 50;

    @Override
    public void create(Graphics g){
        g.drawRect((int) x, (int) y, width, height);
        g.setColor(Color.GREEN);
        g.fillRect((int) x, (int) y, width, height);
    }

    @Override
    public void update(){

        x -= velocity;

    }

}
