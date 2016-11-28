package com.csciOOD;

public class ObstacleFactory {

    public Obstacle getObstacle(String obstType){
        if(obstType == null){
            return null;
        }
        if(obstType.equalsIgnoreCase("frog")) {
            return new Frog();
        }
        else if(obstType.equalsIgnoreCase("butterfly")) {
            return new Butterfly();
        }
        else if(obstType.equalsIgnoreCase("bird")) {
            return new Bird();
        }
        else if(obstType.equalsIgnoreCase("biker")) {
            return new Biker();
        }

        return null;
    }

}
