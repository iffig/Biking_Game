package com.csciOOD;

public class Sprite {
    // "State" Flags

    public boolean isNaturalSlow = false;
    public boolean isSpeedingUp = false;
    public boolean isSlowingDown = false;

    // Rates of Movement
    public float xVelocity = 5;
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


    // Character Specs
    public int width = 42;
    public int height = 42;
    public int original_height = 42;
    public int duck_height = 21;

    // Jump Specs
    public float jump_height = 400;

    public Sprite(){}


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
            y = y-1;
    }

    public void duck(){
        height = duck_height;
        y = ground_height + duck_height;
    }

    public void unDuck(){
        y = ground_height;
        height = original_height;
    }

    public void sendToStart(){
        if(x > start_position){
          isSlowingDown = true;
        }
        if(x < start_position){
            isSpeedingUp = true;
        }
    }

    public void update(){
        //Falling Motion
        if(y < ground_height){
            y += yVelocity;
        }

        if(isNaturalSlow){
            if(x > start_position){
                x -= naturalSlowSpeed;
            }
        }

        if(isSpeedingUp){

            x += speedUp;
        }

        if(isSlowingDown){
            x -= slowSpeed;
        }

        //   If we hit a wall...
        if (wallWasHit()) {
            // reverse direction
            //xVelocity = -xVelocity;
            sendToStart();

        }

        //This shouldn't happen
        if (ceilOrFloorWasHit()) {
            yVelocity = -yVelocity;
        }
    }
}
