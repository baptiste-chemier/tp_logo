/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.ControleurIhmFlock;
import Modele.TortueFlock;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

/**
 *
 * @author Epulapp
 */
public class VueIhmFlock extends JFrame implements Observer {

    protected VueTortue vueTortue;
    public static final Dimension VGAP = new Dimension(1, 5);
    public static final Dimension HGAP = new Dimension(5, 1);
    private List<TortueFlock> listTortue;
    protected ControleurIhmFlock controleur;
    protected int clickX, clickY;

    public VueIhmFlock() {
        super("Tortue Ninja");
        listTortue = new ArrayList<>();
        controleur = new ControleurIhmFlock(this, listTortue);
        logoInit();
    }

    public void logoInit() {
        getContentPane().setLayout(new BorderLayout(10, 10));

        // Boutons
        JToolBar toolBar = new JToolBar();
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(toolBar);

        getContentPane().add(buttonPanel, "North");

        // Menus
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);	// on installe le menu bar
        JMenu menuFile = new JMenu("File"); // on installe le premier menu
        menubar.add(menuFile);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        vueTortue = new VueTortue(); //500, 400);
        vueTortue.setBackground(Color.white);
        vueTortue.setSize(new Dimension(constante.Constante.width, constante.Constante.heigh));
        vueTortue.setPreferredSize(new Dimension(constante.Constante.width, constante.Constante.heigh));

        getContentPane().add(vueTortue, "Center");

        // Creation de la tortue
        for (int j = 0; j < constante.Constante.nbTortue; j++) {

            TortueFlock t = new TortueFlock();
            int posX = (int) (Math.random() * (600 - 0)) + 0;
            int posY = (int) (Math.random() * (400 - 0)) + 0;
            t.setPosition(posX / 2, posY / 2);
            int couleur = (int) (Math.random() * (11 - 0)) + 0;
            t.setColor(couleur);
            int vitesse = (int) (Math.random() * (20 - 5)) + 5;
            t.setVitesse(vitesse);

            for (TortueFlock tortueF : listTortue) {
                tortueF.addObserver(this);
            }
            controleur.getListTortue().add(t);
            vueTortue.addTortue(t);
        }

        pack();
        setVisible(true);
    }

    //utilitaires pour installer des boutons et des menus
    public void addButton(JComponent p, String name, String tooltiptext, String imageName) {
        JButton b;
        if ((imageName == null) || (imageName.equals(""))) {
            b = (JButton) p.add(new JButton(name));
        } else {
            java.net.URL u = this.getClass().getResource(imageName);
            if (u != null) {
                ImageIcon im = new ImageIcon(u);
                b = (JButton) p.add(new JButton(im));
            } else {
                b = (JButton) p.add(new JButton(name));
            }
            b.setActionCommand(name);
        }

        b.setToolTipText(tooltiptext);
        b.setBorder(BorderFactory.createRaisedBevelBorder());
        b.setMargin(new Insets(0, 0, 0, 0));
    }

    public void addMenuItem(JMenu m, String label, String command, int key) {
        JMenuItem menuItem;
        menuItem = new JMenuItem(label);
        m.add(menuItem);

        menuItem.setActionCommand(command);
        // menuItem.addActionListener(controleur);
        if (key > 0) {
            if (key != KeyEvent.VK_DELETE) {
                menuItem.setAccelerator(KeyStroke.getKeyStroke(key, Event.CTRL_MASK, false));
            } else {
                menuItem.setAccelerator(KeyStroke.getKeyStroke(key, 0, false));
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        vueTortue.repaint();
    }

    public VueTortue getVueTortue() {
        return vueTortue;
    }

    /**
     * @return the tortue
     */
    public List<TortueFlock> getListTortue() {
        return listTortue;
    }

    public void flockingMode(TortueFlock t) {

        for (TortueFlock tortue : listTortue) {
            double c = t.getX() - tortue.getX();
            double b = t.getY() - tortue.getY();
            double a = Math.sqrt(Math.pow(c, 2) + Math.pow(b, 2));
            double alpha = Math.atan(b / c);
            double angle = 2 * alpha;

            if (a < constante.Constante.distance && angle < constante.Constante.angle * constante.Constante.ratioDegRad) {
                //System.out.println("true");
                t.setVitesse((tortue.getVitesse() + tortue.getVitesse()) / 2);
                t.setColor(tortue.getColor());
                t.setDirection(tortue.getDirection());

                if ((int) Math.sqrt(Math.pow(t.getX() - tortue.getX(), 2) + Math.pow(t.getY() - tortue.getY(), 2)) < 10) {
                    if (t.getDirection() < tortue.getDirection()) {
                        t.setDirection(t.getDirection() + 5);
                        tortue.setDirection(tortue.getDirection() - 5);
                    } else {
                        t.setDirection(t.getDirection() - 5);
                        tortue.setDirection(tortue.getDirection() + 5);

                    }
                } /* else {
                 if (t.getDirection() < tortue.getDirection()) {
                 t.setDirection(t.getDirection() - 40);
                 } else {
                 t.setDirection(t.getDirection() + 40);
                 }
                    
                 t.setVitesse(tortue.getVitesse() - 5);
                 }*/

            }
        }
    }
}
