package com.csciOOD;

import java.awt.*;

public class Biker implements Obstacle{

    float x = start_position;
    float y = ground_height;

    //To detect Point values
    boolean isGoodObject = false;
    int pointValue = 100;

    @Override
    public void create(Graphics g){
        g.drawRect((int) x, (int) y, width, height);
        g.setColor(Color.BLACK);
        g.fillRect((int) x, (int) y, width, height);
    }

    @Override
    public void update(){

        x -= velocity;


    }

}
