package com.csciOOD;

import javax.swing.*;
import com.csciOOD.BouncingObject;

import java.awt.*;

public class Game extends JPanel {
    private BouncingObject demoRect;

    public Game(Container contentPane) {
        demoRect = new BouncingObject(contentPane);


    }

    public void updateGame(){
        demoRect.update();
    }

    public void reRender(){
        demoRect.repaint();
    }
}
