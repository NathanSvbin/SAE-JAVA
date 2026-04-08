package Graphes;

import java.util.HashMap;
import java.util.Map;

public class Matrice{

    private Map<String, Map<String, String>> arcs;

    public Matrice() {
        this.arcs = new HashMap<>();
    }

    public void ajouterSommet(String nom) {
        if (nom != null && !arcs.containsKey(nom)) {
            arcs.put(nom, new HashMap<>());
        }
    }

    public void ajouterArc(String de, String vers, String etiquette) {
        if (arcs.containsKey(de) && arcs.containsKey(vers)) {
            arcs.get(de).put(vers, etiquette);
        }
    }

    public boolean getArc(String de, String vers) {
        if (arcs.containsKey(de)) {
            return arcs.get(de).containsKey(vers) && arcs.get(de).get(vers) != null;
        }
        return false;
    }
    
    public String getValeurArcs(String de, String vers) {
    	assert(getArc(de, vers));
    	return arcs.get(de).get(vers);
    }
}