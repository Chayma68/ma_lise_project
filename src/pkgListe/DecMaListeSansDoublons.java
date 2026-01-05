package pkgListe;

import java.util.HashSet;
import java.util.Set;

/**
 * Décorateur supprimant les doublons d'une MaListe.
 * Permet d'enrichir une liste existante en éliminant toutes les valeurs
 * répétées sans modifier la classe d'origine.
 */
public class DecMaListeSansDoublons extends DecoratorMaListe {

    /**
     * Construit un décorateur éliminant les doublons sur la liste donnée.
     *
     * @param liste la liste à décorer
     */
    public DecMaListeSansDoublons(MaListe liste) {
        super(liste);
    }

    /**
     * Supprime toutes les occurrences de valeurs en double dans la liste décorée.
     */
    @Override
    public void decore() {
        Liste l = liste.getListe();
        Set<Integer> vus = new HashSet<>();
        boolean modifie = false;
        // Gestion de la tête de liste
        while (!l.estVide() && vus.contains(l.getPremier().getValeur())) {
            l.supprimerPremier();
            modifie = true;
        }
        // Si la liste est vide après nettoyage initial
        if (l.estVide()) {
            if (modifie) {
                liste.notifierAllObs();
            }
            return;
        }
        vus.add(l.getPremier().getValeur());
        ElementListe prev = l.getPremier();
        ElementListe cur = prev.getSuivant();
        while (cur != null) {
            int valeur = cur.getValeur();
            if (vus.contains(valeur)) {
                // suppression du doublon
                prev.setSuivant(cur.getSuivant());
                cur = prev.getSuivant();
                modifie = true;
            } else {
                vus.add(valeur);
                prev = cur;
                cur = cur.getSuivant();
            }
        }
        if (modifie) {
            liste.notifierAllObs();
        }
    }
}