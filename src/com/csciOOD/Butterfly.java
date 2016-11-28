package com.csciOOD;

import java.awt.*;

public class Butterfly implements Obstacle{

    float x = start_position;
    float y = fly_height;

    //To detect Point values
    boolean isGoodObject = true;
    int pointValue = 50;

    @Override
    public void create(Graphics g){
        g.drawRect((int) x, (int) y, width, height);
        g.setColor(Color.PINK);
        g.fillRect((int) x, (int) y, width, height);
    }

    @Override
    public void update(){
        x -= velocity;
    }

}
