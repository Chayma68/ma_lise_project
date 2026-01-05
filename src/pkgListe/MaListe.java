package pkgListe;

/**
 * Classe adaptateur transformant une Liste en structure de pile.
 * Étend Observe afin de pouvoir notifier des observateurs lorsque
 * la structure est modifiée (push/pop).
 */
public class MaListe extends Observe {
    /** liste interne faisant office de stockage */
    private final Liste liste;

    /**
     * Constructeur par défaut initialisant une liste vide.
     */
    public MaListe() {
        this.liste = new Liste();
    }

    /**
     * Empile une valeur en tête de la liste.
     *
     * @param val valeur à ajouter
     */
    public void push(int val) {
        liste.ajouterAuDebut(val);
        // Notification des observateurs après modification
        notifierAllObs();
    }

    /**
     * Dépile la valeur en tête de la liste.
     *
     * @return la valeur dépilée
     * @throws IllegalStateException si la liste est vide
     */
    public int pop() {
        ElementListe el = liste.supprimerPremier();
        if (el == null) {
            throw new IllegalStateException("La pile est vide");
        }
        notifierAllObs();
        return el.getValeur();
    }

    /**
     * Indique si la liste est vide.
     *
     * @return vrai si aucun élément n'est présent
     */
    public boolean estVide() {
        return liste.estVide();
    }

    /**
     * Vide complètement la liste.
     */
    public void vider() {
        while (!liste.estVide()) {
            liste.supprimerPremier();
        }
        notifierAllObs();
    }

    /**
     * Affiche le contenu de la liste sur la sortie standard.
     */
    public void afficher() {
        System.out.print("[");
        IteratorMaListe it = getIterator();
        boolean premierAffiche = true;
        while (it.hasNext()) {
            ElementListe el = it.next();
            if (!premierAffiche) {
                System.out.print(", ");
            }
            System.out.print(el.getValeur());
            premierAffiche = false;
        }
        System.out.println("]");
    }

    /**
     * Fournit un itérateur pour parcourir la liste.
     *
     * @return un nouvel itérateur démarrant au premier élément
     */
    public IteratorMaListe getIterator() {
        return new IteratorMaListe(liste.getPremier());
    }

    /**
     * Accesseur pour la liste interne (utilisé par les décorateurs).
     *
     * @return la liste interne
     */
    protected Liste getListe() {
        return liste;
    }
}