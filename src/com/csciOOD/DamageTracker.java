package com.csciOOD;

import java.awt.*;

import static com.csciOOD.Obstacle.height;
import static com.csciOOD.Obstacle.width;

public class DamageTracker implements Tracker {

    int damageTracker = 100;

    @Override
    public void increment(int pointValue) {
        damageTracker ++;
    }

    @Override
    public void decrement(int pointValue) {
        damageTracker --;

    }

    @Override
    public void painting(Graphics g) {
        g.setColor(Color.black);
        g.drawString("Health ", 625, 45);
        g.drawRoundRect(550, 50, 200, 25, 10, 10);
        g.fillRoundRect(550, 50, 2*damageTracker, 25, 10, 10);

    }
}
