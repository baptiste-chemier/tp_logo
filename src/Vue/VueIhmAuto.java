/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.ControleurIhmAuto;
import Modele.TortueAuto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.Box;
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
public class VueIhmAuto extends JFrame implements Observer {

    protected VueTortueNormale vueTortue;
    public static final Dimension VGAP = new Dimension(1, 5);
    public static final Dimension HGAP = new Dimension(5, 1);
    private List<TortueAuto> listTortue;
    protected ControleurIhmAuto controleur;
    protected int clickX, clickY;

    public VueIhmAuto() {
        super("Tortue Ninja");
        listTortue = new ArrayList<>();
        controleur = new ControleurIhmAuto(this);
        logoInit();
    }

    public void logoInit() {
        getContentPane().setLayout(new BorderLayout(10, 10));

        // Boutons
        JToolBar toolBar = new JToolBar();
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(toolBar);

        getContentPane().add(buttonPanel, "North");

        toolBar.add(Box.createRigidArea(HGAP));
        addButton(toolBar, "New turtle", "New turtle", null);

        // Menus
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);	// on installe le menu bar
        JMenu menuFile = new JMenu("File"); // on installe le premier menu
        menubar.add(menuFile);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        vueTortue = new VueTortueNormale(); //500, 400);
        vueTortue.setBackground(Color.white);
        vueTortue.setSize(new Dimension(600, 400));
        vueTortue.setPreferredSize(new Dimension(600, 400));

        getContentPane().add(vueTortue, "Center");

        // Creation de la tortue
        TortueAuto tortue = new TortueAuto();

        // Deplacement de la tortue au centre de la vueTortue
        int posX = (int) (Math.random() * (600 - 0)) + 0;
        int posY = (int) (Math.random() * (400 - 0)) + 0;
        tortue.setPosition(posX / 2, posY / 2);

        listTortue.add(tortue);
        for(int i = 0; i < listTortue.size(); i++)
            this.getListTortue().get(i).addObserver(this);
        
        controleur.getListTortue().add(tortue);
        vueTortue.addTortue(tortue);

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
        b.addActionListener(controleur);
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

    public VueTortueNormale getVueTortue() {
        return vueTortue;
    }

    /**
     * @return the tortue
     */
    public List<TortueAuto> getListTortue() {
        return listTortue;
    }
}
