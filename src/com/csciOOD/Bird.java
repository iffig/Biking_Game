package com.csciOOD;

import java.awt.*;

public class Bird implements Obstacle{

    public boolean isOnScreen = true;
    float x = start_position;
    float y = fly_height;

    //To detect Point values
    boolean isGoodObject = false;
    int pointValue = 50;
    @Override
    public boolean getIsOnScreen(){
        return isOnScreen;
    }
    @Override
    public void create(Graphics g){
        g.setColor(Color.YELLOW);
        g.drawRect((int) x, (int) y, width, height);
        g.setColor(Color.YELLOW);
        g.fillRect((int) x, (int) y, width, height);
    }

    @Override
    public void update(){

        x -= velocity;
        if(x < -width){
            isOnScreen = false;
        }

    }

}
