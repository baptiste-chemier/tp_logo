/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Tortue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Epulapp
 */
public class VueTortue extends JPanel {
    
    List<Tortue> tortues;
    
    public VueTortue() {
        tortues = new ArrayList<>();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color c = g.getColor();

        Dimension dim = getSize();
        g.setColor(Color.white);
        g.fillRect(0, 0, dim.width, dim.height);
        g.setColor(c);

        showTurtles(g);
    }
    
    public void addTortue(Tortue o) {
        tortues.add(o);
        
    }
    
    public void reset() {
        for (Iterator it = tortues.iterator(); it.hasNext();) {
            Tortue t = (Tortue) it.next();
            t.getComportement().reset();
        }
    }

    public void showTurtles(Graphics g) {
        
        for (Iterator it = tortues.iterator(); it.hasNext();) {
            Tortue t = (Tortue) it.next();
            t.getComportement().drawTurtle(g);
        }
    }
    
    public Tortue getClickedTortue(int x, int y, Tortue t){
        for (int i = 0; i<tortues.size(); i++) {
            if (tortues.get(i).getComportement().getForme().contains(new Point(x, y))) {
                return tortues.get(i);
            }
        }
        return t;
    }

}
