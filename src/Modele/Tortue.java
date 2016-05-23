/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.Color;
import java.util.Observable;

/**
 *
 * @author Epulapp
 */
public class Tortue extends Observable {
    
    private int x;
    private int y;
    private int direction;
    private boolean crayon;
    private int color;
    private Color couleur;
    private Comportement comportement;
    
    public Tortue() {
        comportement = new Fleche(this);
        comportement.reset();
        
    }
    
    public void couleur(int n) {
        setColor(n % 12);
    }

    public void couleurSuivante() {
        couleur(getColor() + 1);
    }
    
    public void setPosition(int newX, int newY) {
        x = newX;
        y = newY;
    }
    
    protected Color decodeColor(int c) {
        switch (c) {
            case 0:
                return (Color.black);
            case 1:
                return (Color.blue);
            case 2:
                return (Color.cyan);
            case 3:
                return (Color.darkGray);
            case 4:
                return (Color.red);
            case 5:
                return (Color.green);
            case 6:
                return (Color.lightGray);
            case 7:
                return (Color.magenta);
            case 8:
                return (Color.orange);
            case 9:
                return (Color.gray);
            case 10:
                return (Color.pink);
            case 11:
                return (Color.yellow);
            default:
                return (Color.black);
        }
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * @return the crayon
     */
    public boolean isCrayon() {
        return crayon;
    }

    /**
     * @param crayon the crayon to set
     */
    public void setCrayon(boolean crayon) {
        this.crayon = crayon;
    }

    /**
     * @return the color
     */
    public int getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(int color) {
        this.color = color;
    }

    /**
     * @return the couleur
     */
    public Color getCouleur() {
        return couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    /**
     * @return the comportement
     */
    public Comportement getComportement() {
        return comportement;
    }

    /**
     * @param comportement the comportement to set
     */
    public void setComportement(Comportement comportement) {
        this.comportement = comportement;
    }
    
    public void avancer(int dist) {
        int newX = (int) Math.round(this.getX() + dist * Math.cos(Constante.ratioDegRad * this.getDirection()));
        int newY = (int) Math.round(this.getY() + dist * Math.sin(Constante.ratioDegRad * this.getDirection()));

        this.setX(newX);
        this.setY(newY);
        
        setChanged();
        notifyObservers();
    }
    
    public void droite(int ang) {
        this.setDirection((this.getDirection() + ang) % 360);
        
        setChanged();
        notifyObservers();
    }

    public void gauche(int ang) {
        this.setDirection((this.getDirection() - ang) % 360);
        
        setChanged();
        notifyObservers();
    }
}
