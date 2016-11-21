package com.csciOOD;


public class Obstacle {

    // Starting Position
    public float x = 750;
    public float y = 600;


    // Character Specs
    public int width = 42;
    public int height = 42;


    // Rates of Movement
    //public float speed = 2;
    public float xVelocity = 2;
    //public float yVelocity = 2;


    // Jump Specs


    public Obstacle(){}


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

    public void update(){

        x +=xVelocity;

        //   If we hit a wall...
        if (wallWasHit()) {
            // reverse direction
            xVelocity = -xVelocity;
            //x = width / 2;
            //x = width/2;

        }


    }

}
