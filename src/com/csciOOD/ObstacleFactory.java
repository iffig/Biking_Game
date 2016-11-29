package com.csciOOD;

import java.util.Random;

public class ObstacleFactory {

    public Obstacle getObstacle(){

        Random randomObst = new Random();
        int obstChoice = randomObst.nextInt(4);

        if(obstChoice == 0){
            System.out.print("Frog");
            return new Frog();
        }

        else if(obstChoice == 1) {
            System.out.print("butter");
            return new Butterfly();
        }
        else if(obstChoice == 2) {
            System.out.print("bird");
            return new Bird();
        }
        else if(obstChoice == 3) {
            System.out.print("biker");
            return new Biker();
        }

        return null;
    }

}
