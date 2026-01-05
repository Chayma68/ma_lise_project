package pkgListe;

/**
 * Classe représentant un élément d'une liste chaînée.
 * Chaque élément contient une valeur entière et une référence vers
 * l'élément suivant de la liste.
 */
public class ElementListe {
    /** valeur stockée dans l'élément */
    private int valeur;
    /** référence vers l'élément suivant */
    private ElementListe suivant;

    /**
     * Constructeur d'un élément avec une valeur donnée.
     *
     * @param valeur la valeur à stocker
     */
    public ElementListe(int valeur) {
        this.valeur = valeur;
    }

    /**
     * Obtient la valeur de cet élément.
     *
     * @return la valeur stockée
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * Change la valeur de cet élément.
     *
     * @param valeur nouvelle valeur
     */
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    /**
     * Renvoie l'élément suivant dans la liste.
     *
     * @return l'élément suivant, ou null si aucun
     */
    public ElementListe getSuivant() {
        return suivant;
    }

    /**
     * Définit l'élément suivant dans la liste.
     *
     * @param suivant l'élément à lier après celui-ci
     */
    public void setSuivant(ElementListe suivant) {
        this.suivant = suivant;
    }
}