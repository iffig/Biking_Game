package com.csciOOD;

import java.awt.*;

public class ScoreTracker implements Tracker {
    int score = 0;

    @Override
    public void increment(int pointValue) {
        score += pointValue;

    }

    @Override
    public void decrement(int pointValue) {
        if ((score - pointValue) <= 0){
            score = 0;
        }
        else{
            score -= pointValue;
        }
    }

    @Override
    public void painting(Graphics g) {
        g.setColor(Color.black);
        g.drawString("Score ", 50, 45);
        g.drawString(( Integer.toString(score)), 100, 45);

    }
}