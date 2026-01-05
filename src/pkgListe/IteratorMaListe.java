package pkgListe;

/**
 * Iterateur sur les éléments d'une liste chaînée.
 * Permet de parcourir séquentiellement une instance de MaListe.
 */
public class IteratorMaListe {
    /** élément courant lors de l'itération */
    private ElementListe courant;

    /**
     * Construit un itérateur à partir du premier élément de la liste.
     *
     * @param premier premier élément à parcourir
     */
    public IteratorMaListe(ElementListe premier) {
        this.courant = premier;
    }

    /**
     * Indique s'il reste encore un élément à parcourir.
     *
     * @return vrai si un élément est disponible
     */
    public boolean hasNext() {
        return courant != null;
    }

    /**
     * Renvoie l'élément courant et avance d'un cran dans la liste.
     *
     * @return l'élément couramment pointé
     */
    public ElementListe next() {
        if (courant == null) {
            return null;
        }
        ElementListe courantActuel = courant;
        courant = courant.getSuivant();
        return courantActuel;
    }
}