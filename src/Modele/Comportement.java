/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.Graphics;
import java.awt.Polygon;


/**
 *
 * @author Epulapp
 */
public abstract class Comportement {
    
    protected int state;
    protected Tortue tortue;
    
    public Comportement(Tortue t) {
        tortue = t;
    }
    
    public void reset() {
        tortue.setX(0);
        tortue.setY(0);
        tortue.setDirection(-90);
        tortue.setColor(0);
        tortue.setCrayon(true);
    }
    
    public void avancer(int dist) {
        int newX = (int) Math.round(tortue.getX() + dist * Math.cos(Constante.ratioDegRad * tortue.getDirection()));
        int newY = (int) Math.round(tortue.getY() + dist * Math.sin(Constante.ratioDegRad * tortue.getDirection()));

        tortue.setX(newX);
        tortue.setY(newY);
    }
    
    public void droite(int ang) {
        tortue.setDirection((tortue.getDirection() + ang) % 360);
    }

    public void gauche(int ang) {
        tortue.setDirection((tortue.getDirection() - ang) % 360);
    }
    
    /**
     *
     * @param graph
     */
    public abstract void drawTurtle(Graphics graph);
    public abstract Polygon getForme();
    
}   
