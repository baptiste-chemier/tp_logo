/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logoInit;

import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author Epulapp
 */
public class FeuilleDessin extends JPanel {

    private ArrayList<Tortue> tortues; // la liste des tortues enregistrees

    public FeuilleDessin() {
        tortues = new ArrayList<Tortue>();
    }

    public void addTortue(Tortue o) {
        tortues.add(o);
    }

    public void reset() {
        for (Iterator it = tortues.iterator(); it.hasNext();) {
            Tortue t = (Tortue) it.next();
            t.reset();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color c = g.getColor();

        Dimension dim = getSize();
        g.setColor(Color.white);
        g.fillRect(0, 0, dim.width, dim.height);
        g.setColor(c);

        showTurtles(g);
    }

    public void showTurtles(Graphics g) {
        for (Iterator it = tortues.iterator(); it.hasNext();) {
            Tortue t = (Tortue) it.next();
            t.drawTurtle(g);
        }
    }
}
