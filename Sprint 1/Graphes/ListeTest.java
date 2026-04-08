package Graphes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListeTest {

    Liste graphe = new Liste();

    @Test
    public void testAjouterSommet() {
        graphe.ajouterSommet("Marie PIA CANTEL");
        graphe.ajouterArc("Marie PIA CANTEL", "Marie PIA CANTEL", "Présente");
        assertTrue(graphe.getArcs("Marie PIA CANTEL", "Marie PIA CANTEL"));
    }

    @Test
    public void testAjouterArcValide() {
        graphe.ajouterSommet("Denis POITRENAUD");
        graphe.ajouterSommet("Veronique BEDOS");
        graphe.ajouterArc("Denis POITRENAUD", "Veronique BEDOS", "Collègue");

        assertTrue(graphe.getArcs("Denis POITRENAUD", "Veronique BEDOS"));
        assertFalse(graphe.getArcs("Veronique BEDOS", "Denis POITRENAUD"));
    }

    @Test
    public void testAjouterArcInexistant() {
        graphe.ajouterSommet("Julien ROSSIT");
        graphe.ajouterArc("Julien ROSSIT", "Veronique BEDOS", "Collègue");

        assertFalse(graphe.getArcs("Julien ROSSIT", "Karim FOUGHALI"));
    }

    @Test
    public void testGetArcAvecSommetInconnu() {
        assertFalse(graphe.getArcs("Jerome FESSY", "Laurent GIUSTIGNANO"));
    }
}
