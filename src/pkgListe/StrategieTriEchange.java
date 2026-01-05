package pkgListe;

import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation d'une stratégie de tri par échange (bubble sort).
 */
public class StrategieTriEchange implements StrategieTri {
    @Override
    public void trier(MaListe liste) {
        // Extraire les valeurs dans une liste temporaire
        List<Integer> valeurs = new ArrayList<>();
        IteratorMaListe it = liste.getIterator();
        while (it.hasNext()) {
            ElementListe el = it.next();
            valeurs.add(el.getValeur());
        }
        // Tri à bulles
        int n = valeurs.size();
        boolean echange;
        do {
            echange = false;
            for (int i = 0; i < n - 1; i++) {
                if (valeurs.get(i) > valeurs.get(i + 1)) {
                    int tmp = valeurs.get(i);
                    valeurs.set(i, valeurs.get(i + 1));
                    valeurs.set(i + 1, tmp);
                    echange = true;
                }
            }
            n--;
        } while (echange);
        // Reconstruction de la liste en ordre trié
        Liste l = liste.getListe();
        // vider la liste sans notifier
        while (!l.estVide()) {
            l.supprimerPremier();
        }
        for (int i = valeurs.size() - 1; i >= 0; i--) {
            l.ajouterAuDebut(valeurs.get(i));
        }
        liste.notifierAllObs();
    }
}