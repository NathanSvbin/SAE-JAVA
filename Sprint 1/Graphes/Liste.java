package Graphes;

import java.util.*;

public class Liste {

    private HashMap<String, String> arcs;
    private List<String> sommet = new ArrayList<>();

    public Liste() {
        this.arcs = new HashMap<>();
    }

    public void ajouterSommet(String nom) {
        if (!sommet.contains(nom)) {
            sommet.add(nom);
        }
    }

    public void ajouterArc(String de, String vers, String etiquette) {
        if (sommet.contains(de) && sommet.contains(vers)) {
            if (!arcs.containsKey(de + "->" + vers)) {
                arcs.put(de + "->" + vers, etiquette);
            }
        }
    }

    public boolean getArcs(String de, String vers) {
        return arcs.containsKey(de + "->" + vers);
    }
    
    public String getValeurArcs(String de, String vers) {
    	assert(getArcs(de, vers));
    	return arcs.get(de + "->" + vers);
    }
}

