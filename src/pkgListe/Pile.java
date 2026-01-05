package pkgListe;

/**
 * Classe représentant une pile qui utilise une MaListe pour la gestion
 * des éléments. Cette classe illustre l'utilisation de l'adaptateur
 * MaListe dans un contexte client.
 */
public class Pile {
    /** liste sous-jacente représentant la pile */
    private final MaListe liste;

    /**
     * Construit une pile vide utilisant une nouvelle MaListe.
     */
    public Pile() {
        this.liste = new MaListe();
    }

    /**
     * Construit une pile basée sur une MaListe existante.
     *
     * @param liste la liste à utiliser comme base
     */
    public Pile(MaListe liste) {
        this.liste = liste;
    }

    /**
     * Empile une valeur sur la pile.
     *
     * @param val valeur à empiler
     */
    public void push(int val) {
        liste.push(val);
    }

    /**
     * Dépile la valeur en haut de la pile.
     *
     * @return la valeur dépilée
     */
    public int pop() {
        return liste.pop();
    }

    /**
     * Indique si la pile est vide.
     *
     * @return vrai si aucun élément n'est présent
     */
    public boolean estVide() {
        return liste.estVide();
    }

    /**
     * Vide complètement la pile.
     */
    public void vider() {
        liste.vider();
    }

    /**
     * Affiche le contenu de la pile.
     */
    public void afficher() {
        liste.afficher();
    }
}