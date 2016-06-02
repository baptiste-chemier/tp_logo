/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Vue.Fleche;
import Vue.Formes;
import constante.Constante;

/**
 *
 * @author Epulapp
 */
public class TortueFlock extends Tortue {
    
    private int x;
    private int y;
    private int direction;
    private int color;
    private Formes formes;
    private Double vitesse;
    private final int distance = 20;
    
    public TortueFlock() {
        this.x = 0;
        this.y = 0;
        this.direction = (int) (Math.random() * (360 - 0)) + 0;
        this.color = (int) (Math.random() * (11 - 0)) + 0;
        this.formes = new Fleche(this);
        this.vitesse = (int) (Math.random() * (20.0 - 5.0)) + 5.0;
    }

    @Override
    public void couleur(int n) {
        setColor(n % 12);
    }

    @Override
    public void couleurSuivante() {
        couleur(getColor() + 1);
    }

    @Override
    public void setPosition(int newX, int newY) {
        x = newX;
        y = newY;
    }

    /**
     * @return the x
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the direction
     */
    @Override
    public int getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    @Override
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * @return the color
     */
    @Override
    public int getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    @Override
    public void setColor(int color) {
        this.color = color;
    }

    public void avancer() {
        int newX = (int) Math.round(this.getX() + getVitesse() * Math.cos(Constante.ratioDegRad * this.getDirection()));
        int newY = (int) Math.round(this.getY() + getVitesse() * Math.sin(Constante.ratioDegRad * this.getDirection()));

        if (newX > constante.Constante.width) {
            this.setX(0);

        } else if (newX < 0) {
            this.setX(constante.Constante.width);

        } else {
            this.setX(newX);
        }
        if (newY > constante.Constante.heigh) {
            this.setY(0);

        } else if (newY < 0) {
            this.setY(constante.Constante.heigh);

        } else {
            this.setY(newY);
        }
        
        notifier();
    }

    @Override
    public void droite(int ang) {
        this.setDirection((this.getDirection() + ang) % 360);
        notifier();
    }

    @Override
    public void gauche(int ang) {
        this.setDirection((this.getDirection() - ang) % 360);
        notifier();
    }

    @Override
    public void notifier() {
        setChanged();
        notifyObservers();
    }

    /**
     * @return the formes
     */
    @Override
    public Formes getFormes() {
        return formes;
    }

    /**
     * @param formes the formes to set
     */
    @Override
    public void setFormes(Formes formes) {
        this.formes = formes;
    }

    /**
     * @return the vitesse
     */
    public Double getVitesse() {
        return vitesse;
    }

    /**
     * @param vitesse the vitesse to set
     */
    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }

    /**
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }
}
