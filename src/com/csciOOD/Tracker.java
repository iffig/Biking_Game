package com.csciOOD;
import java.awt.Graphics;
public interface Tracker {

    void increment(int pointValue);
    void decrement(int pointValue);
    void painting(Graphics g);

}
