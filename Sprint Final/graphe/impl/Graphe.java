package graphe.impl;
import java.util.*;
import graphe.modele.*;

public class Graphe implements IGraphe{
	
    private Map<IEntite, Map<IEntite, Set<NatureRelation>>> arcs;
    private Map<IEntite, Map<IEntite, Set<NatureRelation>>> arcsInverses;

    public Graphe() {
    	
        this.arcs = new HashMap<>();
        this.arcsInverses = new HashMap<>();
    }

	@Override
	public boolean ajouterEntite(IEntite entite) {
		
		if (arcs.containsKey(entite)) {
            return false;
        }
        arcs.put(entite, new HashMap<>());
        arcsInverses.put(entite, new HashMap<>());
        return true;
	}

	@Override
	public boolean ajouterRelation(IEntite source, IEntite cible, NatureRelation nature) {
		
        ajouterEntite(source);
        ajouterEntite(cible);

        Map<IEntite, Set<NatureRelation>> Source = arcs.get(source);
        if (!Source.containsKey(cible)) {
        	Source.put(cible, new HashSet<>());
        }
        boolean ajout = Source.get(cible).add(nature);
        
        if (ajout) {
            Map<IEntite, Set<NatureRelation>> Cible = arcsInverses.get(cible);
            if (!Cible.containsKey(source)) {
            	Cible.put(source, new HashSet<>());
            }
            Cible.get(source).add(nature);
        }

        return ajout;
	}

	@Override
	public Set<IEntite> entites() {
        return arcs.keySet();
	}

	@Override
	public Set<RelationSortante> relationsSortantes(IEntite source) {
		
        Set<RelationSortante> resultat = new HashSet<>();
        for (Map.Entry<IEntite, Set<NatureRelation>> entree : arcs.get(source).entrySet()) {
            IEntite cible = entree.getKey();
            for (NatureRelation i : entree.getValue()) {
                resultat.add(new RelationSortante(cible, i));
            }
        }
        return resultat;
	}

	@Override
	public Set<RelationEntrante> relationsEntrantes(IEntite cible) {
		
        Set<RelationEntrante> resultat = new HashSet<>();
        for (Map.Entry<IEntite, Set<NatureRelation>> entree : arcsInverses.get(cible).entrySet()) {
            IEntite source = entree.getKey();
            for (NatureRelation i : entree.getValue()) {
                resultat.add(new RelationEntrante(source, i));
            }
        }
        return resultat;
	}

}
