package com.csciOOD;

import java.awt.*;

import static com.csciOOD.Obstacle.height;
import static com.csciOOD.Obstacle.width;

public class DamageTracker implements Tracker {

    int damageTracker = 50;
    //For Health Tracker Colors
    int mildDamage = damageTracker/2;
    int badDamage = damageTracker/4;
    int criticalDamage = damageTracker/5;
    boolean isGameOver = false;

    public boolean getIsGameOver(){
        return isGameOver;
    }

    @Override
    public void increment(int pointValue) {
        damageTracker ++;
    }

    @Override
    public void decrement(int pointValue) {
        damageTracker --;
        if(damageTracker <= 0){
            isGameOver = true;
        }

    }

    @Override
    public void painting(Graphics g) {
        g.setColor(Color.GREEN);
        if(damageTracker < mildDamage){g.setColor(Color.YELLOW);}
        if(damageTracker < badDamage){g.setColor(Color.ORANGE);}
        if(damageTracker < criticalDamage){g.setColor(Color.RED);}
        g.fillRoundRect(550, 50, 4*damageTracker, 25, 10, 10);

        g.setColor(Color.BLACK);
        g.drawString("Health ", 625, 45);
        g.drawRoundRect(550, 50, 200, 25, 10, 10);

    }
}
