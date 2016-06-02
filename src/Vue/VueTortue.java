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
            t.reset();
        }
    }

    public void showTurtles(Graphics g) {

        for (Iterator it = tortues.iterator(); it.hasNext();) {
            Tortue t = (Tortue) it.next();
            drawTurtle(g, t);
        }
    }

    public Tortue getClickedTortue(int x, int y, Tortue t) {

        for (Tortue tortue : tortues) {
            if (tortue.getFormes().getArrow().contains(new Point(x, y))) {
                return tortue;
            }
        }

        return t;
    }

    public void drawTurtle(Graphics graph, Tortue t) {
        if (graph == null) {
            return;
        }
        t.getFormes().drawTurtle(t);
        graph.setColor(decodeColor(t.getColor()));
        graph.fillPolygon(t.getFormes().getArrow());
    }

    public Point getChamp() {
        return null;
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
}
