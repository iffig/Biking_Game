package com.csciOOD;

import java.awt.*;
import java.util.Random;
import java.lang.*;

/* Dilara: I have a problem making the biker just to jump or duck and keep going.
 Right now we have a Schrodinger's bike that is jumping and ducking at the same time.
 That functionality is commented out now, if I can I will correct this before Tuesday.
 */

public class Biker implements Obstacle{

    public boolean isOnScreen = true;
    float x = start_position;
    float y = ground_height;
    public boolean isCollided = false;

    public int height = 50;
    public float jump_height = 400;
    public float yVelocity = 2;
    public int original_height = 50;
    public int duck_height = (original_height/2);

    int randomInt = 0;
    public boolean isJumping = false;
    public boolean isDucking = false;
    public int state = 0;

    @Override
    public boolean getisGood() {
        return isGoodObject;
    }

    @Override
    public int getpointValue() {
        return pointValue;
    }

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
    public void update() {

        x -= velocity;
        //random_choice();
        if(x < -width){
            isOnScreen = false;
        }
        if(isCollided){
            isOnScreen = false;
            isCollided = false;
        }
        /*
        if (state == 1){
            duck();
            isDucking = false;
        }
        else if (state == 2){
            jump();
            isJumping = false;
        }
        */
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y, width, height);
    }

    public void setisCollided(boolean bool) {
        isCollided = bool;
    }


    public void jump(){
        while(y > jump_height)
            y -=yVelocity;
    }

    public void duck(){
        height = duck_height;
        y = ground_height + duck_height;
    }

    /*
    public int random_choice(){
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(3);
            //boolean[] random_option = new boolean[2];
            //random_option[0] = isJumping;
            //random_option[1] = isDucking;

            if (randomInt == 0){
                isJumping = false;
                isDucking = false;
                state = 0;
            }
            else if (randomInt == 1){
                isJumping = false;
                isDucking = true;
                state = 1;
            }
            else if (randomInt == 2){
                isJumping = true;
                isDucking = false;
                state = 2;
            }
            return state;
        }
        */


}







