package pkgListe;

import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation d'une stratégie de tri par insertion.
 */
public class StrategieTriInsertion implements StrategieTri {
    @Override
    public void trier(MaListe liste) {
        // Récupération des valeurs dans une liste temporaire
        List<Integer> valeurs = new ArrayList<>();
        IteratorMaListe it = liste.getIterator();
        while (it.hasNext()) {
            ElementListe el = it.next();
            valeurs.add(el.getValeur());
        }
        // Tri par insertion
        for (int i = 1; i < valeurs.size(); i++) {
            int clef = valeurs.get(i);
            int j = i - 1;
            while (j >= 0 && valeurs.get(j) > clef) {
                valeurs.set(j + 1, valeurs.get(j));
                j--;
            }
            valeurs.set(j + 1, clef);
        }
        // Reconstruction de la liste en ordre trié
        // On utilise directement la liste interne pour éviter les notifications multiples
        Liste l = liste.getListe();
        // vider la liste sans notifier
        while (!l.estVide()) {
            l.supprimerPremier();
        }
        // On insère en sens inverse pour respecter l'ordre croissant
        for (int i = valeurs.size() - 1; i >= 0; i--) {
            l.ajouterAuDebut(valeurs.get(i));
        }
        // Notifier une seule fois après reconstruction complète
        liste.notifierAllObs();
    }
}