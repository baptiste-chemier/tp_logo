/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import constante.Constante;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Epulapp
 */
public class TortueAutoTest {

    protected TortueAuto tortue;

    public TortueAutoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tortue = new TortueAuto();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of couleur method, of class TortueAuto.
     */
    @Test
    public void testCouleur() {
        System.out.println("testCouleur");
        tortue.setColor(1);
        Assert.assertEquals(1, tortue.getColor());
    }

    /**
     * Test of couleurSuivante method, of class TortueAuto.
     */
    @Test
    public void testCouleurSuivante() {
        System.out.println("testCouleurSuivante");
        tortue.setColor(1);
        tortue.couleurSuivante();
        Assert.assertEquals(2, tortue.getColor());
    }

    /**
     * Test of avancer method, of class TortueAuto.
     */
    @Test
    public void testAvancer() {
        System.out.println("testAvancer");
        int vitesse = tortue.getVitesse();
        int direction = tortue.getDirection();
        int x = tortue.getX();
        int y = tortue.getY();
        int resultatX = (int) Math.round(x + vitesse * Math.cos(Constante.ratioDegRad * direction));
        int resultatY = (int) Math.round(y + vitesse * Math.sin(Constante.ratioDegRad * direction));
        
        if (resultatX > constante.Constante.width) {
            resultatX = 0;

        } else if (resultatX < 0) {
            resultatX = constante.Constante.width;

        } 
        if (resultatY > constante.Constante.heigh) {
            resultatY = 0;

        } else if (resultatY < 0) {
            resultatY = constante.Constante.heigh;
        }

        tortue.avancer();
        Assert.assertEquals(resultatX, tortue.getX());
        Assert.assertEquals(resultatY, tortue.getY());
    }

    /**
     * Test of droite method, of class TortueAuto.
     */
    @Test
    public void testDroite() {
        System.out.println("testDroite");
        int direction = tortue.getDirection();
        tortue.droite(90);
        Assert.assertEquals((direction + 90) % 360, tortue.getDirection());
    }

    /**
     * Test of gauche method, of class TortueAuto.
     */
    @Test
    public void testGauche() {
        System.out.println("testGauche");
        int direction = tortue.getDirection();
        tortue.gauche(90);
        Assert.assertEquals((direction - 90) % 360, tortue.getDirection());

    }

    /**
     * Test of reset method, of class TortueAuto.
     */
    @Test
    public void testReset() {
        System.out.println("testReset");
        tortue.reset();
        Assert.assertEquals(0, tortue.getX());
        Assert.assertEquals(0, tortue.getY());
    }
}
