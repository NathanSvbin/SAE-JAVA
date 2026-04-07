package Graphes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MatriceTest {
    private Matrice graphe;

    public void setUp() {
        graphe = new Matrice();
    }

    public void testAjouterSommet() {
        graphe.ajouterSommet("CAppliChenille");
        graphe.ajouterArc("CAppliChenille", "CAppliChenille");
        assertTrue(graphe.getArc("CAppliChenille", "CAppliChenille"), "Le sommet devrait exister et accepter un arc.");
    }

    public void testAjouterArcValide() {
        graphe.ajouterSommet("CChenille");
        graphe.ajouterSommet("Anneau");
        graphe.ajouterArc("CChenille", "Anneau");

        assertTrue(graphe.getArc("CChenille", "Anneau"), "L'arc CChenille -> Anneau devrait exister.");
        assertFalse(graphe.getArc("Anneau", "CChenille"), "Le graphe est orienté, l'inverse ne devrait pas exister.");
    }

    public void testAjouterArcInexistant() {
        graphe.ajouterSommet("CChenille");
        graphe.ajouterArc("CChenille", "Anneau");

        assertFalse(graphe.getArc("CChenille", "Anneau"), "L'arc ne doit pas être créé si le sommet cible n'existe pas.");
    }

    public void testGetArcAvecSommetInconnu() {
        assertFalse(graphe.getArc("Inconnu1", "Inconnu2"), "getArc doit renvoyer false si les sommets n'existent pas.");
    }
}