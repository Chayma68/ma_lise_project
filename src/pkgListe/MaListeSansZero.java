package pkgListe;

/**
 * Variante de MaListe éliminant les éléments de valeur zéro.
 * Cette classe hérite du comportement de MaListe et ajoute une
 * opération pour supprimer toutes les occurrences de zéro.
 */
public class MaListeSansZero extends MaListe {

    /**
     * Supprime toutes les occurrences de zéro dans la liste.
     * Après suppression, notifie les observateurs si la liste a été modifiée.
     */
    public void EliminerZero() {
        Liste l = getListe();
        boolean modifie = false;
        // Suppression des zéros en tête
        while (!l.estVide() && l.getPremier().getValeur() == 0) {
            l.supprimerPremier();
            modifie = true;
        }
        // Suppression des zéros dans le reste de la liste
        ElementListe prev = l.getPremier();
        if (prev != null) {
            ElementListe curr = prev.getSuivant();
            while (curr != null) {
                if (curr.getValeur() == 0) {
                    prev.setSuivant(curr.getSuivant());
                    curr = prev.getSuivant();
                    modifie = true;
                } else {
                    prev = curr;
                    curr = curr.getSuivant();
                }
            }
        }
        if (modifie) {
            notifierAllObs();
        }
    }
}