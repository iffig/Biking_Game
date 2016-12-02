package com.csciOOD;

import java.awt.*;

public class Biker implements Obstacle{

    public boolean isOnScreen = true;
    float x = start_position;
    float y = ground_height;
    public boolean isCollided = false;

    //To detect Point values
    boolean isGoodObject = false;
    int pointValue = 100;
    @Override
    public boolean getIsOnScreen(){
        return isOnScreen;
    }
    @Override
    public void create(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect((int) x, (int) y, width, height);
        g.setColor(Color.BLACK);
        g.fillRect((int) x, (int) y, width, height);
    }

    @Override
    public void update(){

        x -= velocity;
        if(x < -width){
            isOnScreen = false;
        }
        if(isCollided){
            isOnScreen = false;
            isCollided = false;
        }

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, width, height);
    }

    public void setisCollided(boolean bool) {
        isCollided = bool;
    }

}
