package Graphes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MatriceTest { 

    Matrice graphe = new Matrice();

    @Test
    public void testAjouterSommet() {
        graphe.ajouterSommet("Marie PIA CANTEL");
        graphe.ajouterArc("Marie PIA CANTEL", "Marie PIA CANTEL", "Présente");
        assertTrue(graphe.getArc("Marie PIA CANTEL", "Marie PIA CANTEL"));
    }

    @Test
    public void testAjouterArcValide() {
        graphe.ajouterSommet("Denis POITRENAUD");
        graphe.ajouterSommet("Veronique BEDOS");
        graphe.ajouterArc("Denis POITRENAUD", "Veronique BEDOS", "Collègue");

        assertTrue(graphe.getArc("Denis POITRENAUD", "Veronique BEDOS"));
        assertFalse(graphe.getArc("Veronique BEDOS", "Denis POITRENAUD"));
    }

    @Test
    public void testAjouterArcInexistant() {
        graphe.ajouterSommet("Julien ROSSIT");
        graphe.ajouterArc("Julien ROSSIT", "Veronique BEDOS", "Collègue");

        assertFalse(graphe.getArc("Julien ROSSIT", "Karim FOUGHALI"));
    }

    @Test
    public void testGetArcAvecSommetInconnu() {
        assertFalse(graphe.getArc("Jerome FESSY", "Laurent GIUSTIGNANO"));
    }
}