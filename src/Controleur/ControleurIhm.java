/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import Modele.Constante;
import Modele.Tortue;
import Vue.VueIhm;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Epulapp
 */
public class ControleurIhm implements ActionListener {
    
    protected VueIhm ihm;
    protected Tortue tortue;
    
    public ControleurIhm (VueIhm i, Tortue t) {
        ihm = i;
        tortue = t;
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
     * la gestion des actions des boutons
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();

        // actions des boutons du haut
        if (c.equals("Avancer")) {
            System.out.println("command avancer");
            try {
                int v = Integer.parseInt(ihm.getInputValue());
                avancer(v);
            } catch (NumberFormatException ex) {
                System.err.println("ce n'est pas un nombre : " + ihm.getInputValue());
            }

        } else if (c.equals("Droite")) {
            try {
                int v = Integer.parseInt(ihm.getInputValue());
                droite(v);
            } catch (NumberFormatException ex) {
                System.err.println("ce n'est pas un nombre : " + ihm.getInputValue());
            }
        } else if (c.equals("Gauche")) {
            try {
                int v = Integer.parseInt(ihm.getInputValue());
                gauche(v);
            } catch (NumberFormatException ex) {
                System.err.println("ce n'est pas un nombre : " + ihm.getInputValue());
            }
        } // actions des boutons du bas
        else if (c.equals("Effacer")) {
            effacer();
        } else if (c.equals("Quitter")) {
            quitter();
        }

        ihm.repaint();
    }
    
    // efface tout et reinitialise la feuille
    public void effacer() {
        ihm.getVueTortue().reset();
        ihm.repaint();
        
        // Replace la tortue centre
        Dimension size = ihm.getSize();
        tortue.setPosition(size.width / 2, size.height / 2);
    }
    
    public void quitter() {
        System.exit(0);
    }
}
