/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.TortueAuto;
import Vue.VueIhmAuto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Epulapp
 */
public class ControleurIhmAuto extends Thread implements ActionListener {

    protected VueIhmAuto ihmAuto;
    private List<TortueAuto> listTortue;

    @Override
    public void run() {
        while (true) {
            try {
                // traitement
                System.out.println("Ligne affichée par le thread");
                for (int i = 0; i < getListTortue().size(); i++) {
                    getListTortue().get(i).avancer();
                }
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControleurIhmAuto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ControleurIhmAuto(VueIhmAuto i) {
        ihmAuto = i;
        listTortue = new ArrayList<>();
    }

    /**
     * la gestion des actions des boutons
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.listTortue = this.ihmAuto.getListTortue();
        String c = e.getActionCommand();

        // actions des boutons du haut
        if (c.equals("New turtle")) {
            addTurtle();
        }
    }

    public void addTurtle() {
        //System.out.println("passe Controleur");
        TortueAuto t = new TortueAuto();

        int posX = (int) (Math.random() * (600 - 0)) + 0;
        int posY = (int) (Math.random() * (400 - 0)) + 0;
        t.setPosition(posX / 2, posY / 2);
        int couleur = (int) (Math.random() * (11 - 0)) + 0;
        t.setColor(couleur);
        int dist = (int) (Math.random() * (20 - 5)) + 5;
        t.setDist(dist);

        ihmAuto.getListTortue().add(t);
        ihmAuto.getVueTortue().addTortue(t);

        t.addObserver(ihmAuto);
        t.notifier();;
    }

    /**
     * @return the listTortue
     */
    public List<TortueAuto> getListTortue() {
        return listTortue;
    }
}
