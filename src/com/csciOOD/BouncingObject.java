package com.csciOOD;

public class BouncingObject {
    public float x = 200;
    public float y = 200;
    public int width = 42;
    public int height = 42;
    public float speed = 2;
    public float xVelocity = 2;
    public float yVelocity = 2;

    public BouncingObject(){}

    private boolean wallWasHit(){
        boolean leftWallHit = x + width / 2 >= 800;
        boolean rightWallHit = x - width / 2 <= 0;

        return leftWallHit || rightWallHit;
    }

    private boolean ceilOrFloorWasHit(){
        boolean ceilingHit = y + height / 2 >= 800;
        boolean floorHit = y - height / 2 <= 0;

        return ceilingHit || floorHit;
    }

    public void update(){
        x += xVelocity;
        y += yVelocity;

        //   If we hit a wall...
        if (wallWasHit()) {
            // reverse direction
            xVelocity = -xVelocity;
            x = width / 2;
            x = width/2;
        }

        if (ceilOrFloorWasHit()) {
            yVelocity = -yVelocity;
        }
    }
}
