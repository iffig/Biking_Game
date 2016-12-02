package com.csciOOD;

import java.awt.*;

interface Obstacle {

    float ground_height = 600;
    float fly_height = 500;

    float start_position = 800;

    int width = 42;
    int height = 42;

    float velocity = 1;

    boolean getisGood();
    int getpointValue();

    void create(Graphics G);
    void update();
    boolean getIsOnScreen();
    void setisCollided(boolean bool);
    Rectangle getBounds();

}