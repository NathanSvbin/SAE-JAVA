package Graphes;

import java.util.HashMap;
import java.util.Map;

public class Matrice{

    private Map<String, Map<String, Integer>> arcs;

    public Matrice() {
        this.arcs = new HashMap<>();
    }

    public void ajouterSommet(String nom) {
        if (nom != null && !arcs.containsKey(nom)) {
            arcs.put(nom, new HashMap<>());
        }
    }

    public void ajouterArc(String de, String vers) {
        if (arcs.containsKey(de) && arcs.containsKey(vers)) {
            arcs.get(de).put(vers, 1);
        }
    }

    public boolean getArc(String de, String vers) {
        if (arcs.containsKey(de)) {
            return arcs.get(de).containsKey(vers) && arcs.get(de).get(vers) == 1;
        }
        return false;
    }
}