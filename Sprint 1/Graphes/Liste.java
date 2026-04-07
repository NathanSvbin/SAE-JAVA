package Graphes;

import java.util.*;

public class Liste {

    private List<String> arcs;
    private List<String> sommet = new ArrayList<>();

    public Liste() {
        this.arcs = new ArrayList<>();
    }

    public void ajouterSommet(String nom) {
        if (!sommet.contains(nom)) {
            sommet.add(nom);
        }
    }

    public void ajouterArc(String de, String vers) {
        if (sommet.contains(de) && sommet.contains(vers)) {
            if (!arcs.contains(de + "->" + vers)) {
                arcs.add(de + "->" + vers);
            }
        }
    }

    public boolean getArcs(String de, String vers) {
        return arcs.contains(de + "->" + vers);
    }
}

