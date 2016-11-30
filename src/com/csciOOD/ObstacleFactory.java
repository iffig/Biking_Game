package com.csciOOD;

import java.util.Random;

public class ObstacleFactory {

    public Obstacle getObstacle(){

        Random randomObst = new Random();
        int obstChoice = randomObst.nextInt(4);

        if(obstChoice == 0){
            return new Frog();
        }

        else if(obstChoice == 1) {
            return new Butterfly();
        }
        else if(obstChoice == 2) {
            return new Bird();
        }
        else if(obstChoice == 3) {
            return new Biker();
        }

        return null;
    }

}
