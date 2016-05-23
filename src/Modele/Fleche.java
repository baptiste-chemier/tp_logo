/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author Epulapp
 */
public class Fleche extends Comportement {

    public Fleche(Tortue t) {
        super(t);
    }
    
    @Override
    public void drawTurtle(Graphics graph) {
        if (graph == null) {
            return;
        }

        //Calcule les 3 coins du triangle a partir de
        // la position de la tortue p
        Point p = new Point(tortue.getX(), tortue.getY());
        Polygon arrow = new Polygon();

		//Calcule des deux bases
        //Angle de la droite
        double theta = Constante.ratioDegRad * (-tortue.getDirection());
        //Demi angle au sommet du triangle
        double alpha = Math.atan((float) Constante.rb / (float) Constante.rp);
        //Rayon de la fleche
        double r = Math.sqrt(Constante.rp * Constante.rp + Constante.rb * Constante.rb);
		//Sens de la fleche

        //Pointe
        Point p2 = new Point((int) Math.round(p.x + r * Math.cos(theta)),
                (int) Math.round(p.y - r * Math.sin(theta)));
        arrow.addPoint(p2.x, p2.y);
        arrow.addPoint((int) Math.round(p2.x - r * Math.cos(theta + alpha)),
                (int) Math.round(p2.y + r * Math.sin(theta + alpha)));

        //Base2
        arrow.addPoint((int) Math.round(p2.x - r * Math.cos(theta - alpha)),
                (int) Math.round(p2.y + r * Math.sin(theta - alpha)));

        arrow.addPoint(p2.x, p2.y);
        graph.setColor(Color.green);
        graph.fillPolygon(arrow);
    }
    
}
