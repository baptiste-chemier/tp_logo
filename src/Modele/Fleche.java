/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import constante.Constante;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author Epulapp
 */
public class Fleche extends Formes {

    Polygon arrow;

    public Fleche(Tortue t) {
        super(t);
    }

    public void drawTurtle(Tortue tortue) {

        //Calcule les 3 coins du triangle a partir de
        // la position de la tortue p
        Point p = new Point(tortue.getX(), tortue.getY());
        //System.out.println("x : " + tortue.getX() + ", Y: " + tortue.getY());
        arrow = new Polygon();

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
    }

    public Polygon getArrow() {
        return this.arrow;
    }
}
