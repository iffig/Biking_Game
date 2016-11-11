package com.csciOOD;

import javax.swing.*;
import com.csciOOD.BouncingObject;

public class Game extends JPanel {
    private BouncingObject demoRect;

    public Game() {
        demoRect = new BouncingObject();
    }

    public void updateGame(){
        demoRect.update();
    }

    public void reRender(){
        demoRect.repaint();
    }
}
