/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Tortue;
import java.awt.Polygon;


/**
 *
 * @author Epulapp
 */
public abstract class Formes {
    
    protected int x;
    protected int y;
    
    public Formes(Tortue t) {
        this.x = t.getX();
        this.y = t.getY();
        drawTurtle(t);
    }
    
    /**
     *
     * @param graph
     */
    public abstract void drawTurtle(Tortue t);
    public abstract Polygon getArrow();
    
}   
