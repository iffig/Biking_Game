package com.csciOOD;


public class BouncingObject {
    // "State" Flags

    public boolean isSpeedingUp = false;
    public boolean isSlowingDown = false;
    public boolean isDucking = false;

    // Starting Position
    public float x = 50;
    public float y = 600;


    public float ground_height = 600;


    // Character Specs
    public int width = 42;
    public int height = 42;
    public int original_height = 42;

    // Rates of Movement
    public float speed = 2;
    public float xVelocity = 2;
    public float yVelocity = 2;
    public float maxXVelocity = 5;

    // Jump Specs

    public float jump_height = 400;

    public BouncingObject(){}


    private boolean wallWasHit(){
        boolean rightWallHit = x + (width / 2) >= 800;
        boolean leftWallHit = x - (width / 2) <= 0;

        return leftWallHit || rightWallHit;
    }

    private boolean ceilOrFloorWasHit(){
        boolean ceilingHit = y + (height / 2) >= 800;
        boolean floorHit = y - (height / 2) <= 0;

        return ceilingHit || floorHit;
    }

    // Movement Functionality

    public void jump(){
        while(y > jump_height)
            y = y-5;

    }
    public void duck(){
        height = original_height / 2;
        y = ground_height + (original_height / 2);
    }

    public void unDuck(){
        y = ground_height;
        height = original_height;
    }


    public void update(){

        if(y < ground_height){
            y += yVelocity;
        }

        if(isSpeedingUp){
            /* So we don't go too fast -- Must fix
            if(xVelocity < maxXVelocity){
                xVelocity += 1;
            }
            */
            x += (xVelocity/2);
        }
        if(isSlowingDown){
            x -= (xVelocity/2);
        }


        //   If we hit a wall...
        if (wallWasHit()) {
            // reverse direction
            xVelocity = -xVelocity;
            //x = width / 2;
            //x = width/2;
        }
        //This shouldn't happen
        if (ceilOrFloorWasHit()) {
            yVelocity = -yVelocity;
        }

    }

}
