/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import constante.Constante;
import java.awt.Color;

/**
 *
 * @author Epulapp
 */
public class TortueAuto extends Tortue {

    private int x;
    private int y;
    private int direction;
    private int color;
    private Formes formes;
    private Color couleur;
    private int dist;

    public TortueAuto() {
        this.x = 0;
        this.y = 0;
        this.direction = (int) (Math.random() * (360 - 0)) + 0;
        this.color = (int) (Math.random() * (11 - 0)) + 0;
        this.formes = new Fleche(this);
        this.couleur = decodeColor(color);
        this.dist = (int) (Math.random() * (20 - 5)) + 5;
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

    @Override
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
        this.setCouleur(decodeColor(this.color));
    }

    public void avancer() {
        int newX = (int) Math.round(this.getX() + getDist() * Math.cos(Constante.ratioDegRad * this.getDirection()));
        int newY = (int) Math.round(this.getY() + getDist() * Math.sin(Constante.ratioDegRad * this.getDirection()));

        if (newX > 600) {
            this.setX(0);

        } else if (newX < 0) {
            this.setX(600);

        } else {
            this.setX(newX);
        }
        if (newY > 400) {
            this.setY(0);

        } else if (newY < 0) {
            this.setY(400);

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
     * @return the couleur
     */
    @Override
    public Color getCouleur() {
        return couleur;
    }

    /**
     * @param couleur the couleur to set
     */
    @Override
    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    /**
     * @return the dist
     */
    public int getDist() {
        return dist;
    }

    /**
     * @param dist the dist to set
     */
    public void setDist(int dist) {
        this.dist = dist;
    }
}
