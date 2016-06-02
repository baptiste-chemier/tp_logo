/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Tortue;
import Vue.VueIhmNormale;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 *
 * @author Epulapp
 */
public class ControleurIhmNormale implements ActionListener {

    protected VueIhmNormale ihmNormale;
    protected Tortue tortue;
    protected int couleur;

    public ControleurIhmNormale(VueIhmNormale i, Tortue t) {
        ihmNormale = i;
        tortue = t;
    }

    public void setTortue(Tortue t) {
        tortue = t;
    }

    public void avancer(int vitesse) {
        tortue.avancer(vitesse);
    }

    public void droite(int ang) {
        tortue.droite(ang);
    }

    public void gauche(int ang) {
        tortue.gauche(ang);
    }

    /**
     * la gestion des actions des boutons
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.tortue = this.ihmNormale.getTortue();

        String c = e.getActionCommand();

        // actions des boutons du haut
        if (c.equals("Avancer")) {
            //System.out.println("command avancer");
            try {
                int v = Integer.parseInt(ihmNormale.getInputValue());
                avancer(v);
            } catch (NumberFormatException ex) {
                System.err.println("ce n'est pas un nombre : " + ihmNormale.getInputValue());
            }

        } else if (c.equals("Droite")) {
            try {
                int v = Integer.parseInt(ihmNormale.getInputValue());
                droite(v);
            } catch (NumberFormatException ex) {
                System.err.println("ce n'est pas un nombre : " + ihmNormale.getInputValue());
            }
        } else if (c.equals("Gauche")) {
            try {
                int v = Integer.parseInt(ihmNormale.getInputValue());
                gauche(v);
            } catch (NumberFormatException ex) {
                System.err.println("ce n'est pas un nombre : " + ihmNormale.getInputValue());
            }
        } else if (c.equals("New turtle")) {
            addTurtle();
        }// actions des boutons du bas
        else if (c.equals("Effacer")) {
            effacer();
        } else if (c.equals("comboBoxChanged")) {
            JComboBox comboBox = (JComboBox) e.getSource();
            couleur = comboBox.getSelectedIndex();
        } else if (c.equals("Quitter")) {
            quitter();
        }
    }

    // efface tout et reinitialise la feuille
    public void effacer() {
        ihmNormale.getVueTortue().reset();
        // Replace la tortue centre
        tortue.setPosition(500 / 2, 400 / 2);
    }

    public void quitter() {
        System.exit(0);
    }

    public void addTurtle() {
        //System.out.println("passe Controleur");
        Tortue t = new Tortue();

        t.setPosition(500 / 2, 400 / 2);
        t.setColor(couleur);

        ihmNormale.setTortue(t);
        ihmNormale.getVueTortue().addTortue(t);

        t.addObserver(ihmNormale);
        t.notifier();;
    }
}
