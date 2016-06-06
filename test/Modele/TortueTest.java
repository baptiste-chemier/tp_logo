/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Vue.Fleche;
import Vue.Formes;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Epulapp
 */
public class TortueTest {

    protected Tortue tortue;

    public TortueTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        tortue = new Tortue();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of couleur method, of class Tortue.
     */
    @Test
    public void testCouleur() {
        System.out.println("testCouleur");
        tortue.setColor(1);
        Assert.assertEquals(1, tortue.getColor());
    }

    /**
     * Test of couleurSuivante method, of class Tortue.
     */
    @Test
    public void testCouleurSuivante() {
        System.out.println("testCouleurSuivante");
        tortue.setColor(1);
        tortue.couleurSuivante();
        Assert.assertEquals(2, tortue.getColor());
    }

    /**
     * Test of avancer method, of class Tortue.
     */
    @Test
    public void testAvancer() {
        System.out.println("testAvancer");
        int vitesse = 10;
        tortue.avancer(vitesse);
        Assert.assertEquals(10, tortue.getX());
        Assert.assertEquals(0, tortue.getY());

        tortue.avancer(vitesse);
        tortue.setDirection(90);
        tortue.avancer(vitesse);
        Assert.assertEquals(20, tortue.getX());
        Assert.assertEquals(10, tortue.getY());

    }

    /**
     * Test of droite method, of class Tortue.
     */
    @Test
    public void testDroite() {
        System.out.println("testDroite");
        tortue.setDirection(0);
        tortue.droite(90);
        Assert.assertEquals(90, tortue.getDirection());
    }

    /**
     * Test of gauche method, of class Tortue.
     */
    @Test
    public void testGauche() {
        System.out.println("testGauche");
        tortue.setDirection(0);
        tortue.gauche(90);
        Assert.assertEquals(-90, tortue.getDirection());

    }

    /**
     * Test of reset method, of class Tortue.
     */
    @Test
    public void testReset() {
        System.out.println("testReset");
        tortue.setX(90);
        tortue.setY(90);
        tortue.setDirection(90);
        tortue.setColor(8);
        tortue.reset();
        Assert.assertEquals(0, tortue.getX());
        Assert.assertEquals(0, tortue.getY());
    }
}
