package graphe.outils;

import graphe.modele.IGraphe;
import graphe.modele.IEntite;
import graphe.modele.NatureRelation;
import graphe.modele.RelationEntrante;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class AlgorithmesGraphe {
     /**
     * Retourne les entités qui dépendent directement de la cible
     * via une seule arête de dépendance statique.
     *
     * La relation CONTIENT n'est pas prise en compte.
     */
    public static Set<IEntite> dependantsDirects(IGraphe graphe, IEntite cible) {
    	
    	Set<IEntite> resultat = new HashSet<>();
        for (RelationEntrante i : graphe.relationsEntrantes(cible)) {
            if (i.nature().estDependanceStatique()) {
                resultat.add(i.source());
            }
        }
        return resultat;
    }

    /**
     * Retourne les dépendants directs de la cible, puis remonte par contenance :
     * - à travers les types contenants éventuels ;
     * - jusqu'au premier paquetage rencontré, inclus ;
     * - sans jamais remonter au-delà de ce premier paquetage ;
     * - sans erreur si aucun paquetage englobant n'existe.
     */
    public static Set<IEntite> dependantsElargis(IGraphe graphe, IEntite cible) {

        Set<IEntite> resultat = new HashSet<>();
        Set<IEntite> directs = dependantsDirects(graphe, cible);
        resultat.addAll(directs);

        List<IEntite> reste = new ArrayList<>(directs);

        while (!reste.isEmpty()) {
            IEntite entite = reste.removeFirst();

            for (RelationEntrante i : graphe.relationsEntrantes(entite)) {
                if (i.nature() == NatureRelation.CONTIENT) {
                    IEntite conteneur = i.source();

                    if (!resultat.contains(conteneur)) {
                        resultat.add(conteneur);
                        if (conteneur.estType()) {
                            reste.add(conteneur);
                        }
                    }
                }
            }
        }
        return resultat;
    }
}