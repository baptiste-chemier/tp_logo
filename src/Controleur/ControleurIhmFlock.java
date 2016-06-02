/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.TortueFlock;
import Vue.VueIhmFlock;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Epulapp
 */
public class ControleurIhmFlock extends Thread {

    protected VueIhmFlock ihmFlock;
    private List<TortueFlock> listTortue;

    @Override
    public void run() {
        while (true) {
            try {
                for (TortueFlock tortue : getListTortue()) {
                    tortue.avancer();
                    ihmFlock.flockingMode(tortue);
                }

                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControleurIhmFlock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ControleurIhmFlock(VueIhmFlock i, List<TortueFlock> lt) {
        ihmFlock = i;
        listTortue = lt;
    }

    /**
     * @return the listTortue
     */
    public List<TortueFlock> getListTortue() {
        return listTortue;
    }
}
