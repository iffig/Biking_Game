package com.csciOOD;

import java.awt.Graphics;

interface Obstacle {

    float ground_height = 600;
    float fly_height = 500;

    float start_position = 800;

    int width = 42;
    int height = 42;

    float velocity = 1;

    void create(Graphics G);
    void update();
    boolean getIsOnScreen();

}