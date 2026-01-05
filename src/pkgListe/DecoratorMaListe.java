package pkgListe;

/**
 * Classe abstraite pour le motif Décorateur appliqué à MaListe.
 * Un décorateur est lui-même une MaListe qui délègue ses appels à
 * une instance existante de MaListe et peut enrichir son comportement.
 */
public abstract class DecoratorMaListe extends MaListe {
    /** référence vers la MaListe décorée */
    protected final MaListe liste;

    /**
     * Construit un décorateur autour de la liste spécifiée.
     *
     * @param liste la liste à décorer
     */
    public DecoratorMaListe(MaListe liste) {
        this.liste = liste;
    }

    // Délégation des opérations de base vers la liste décorée
    @Override
    public void push(int val) {
        liste.push(val);
    }

    @Override
    public int pop() {
        return liste.pop();
    }

    @Override
    public boolean estVide() {
        return liste.estVide();
    }

    @Override
    public void vider() {
        liste.vider();
    }

    @Override
    public void afficher() {
        liste.afficher();
    }

    @Override
    public IteratorMaListe getIterator() {
        return liste.getIterator();
    }

    @Override
    protected Liste getListe() {
        return liste.getListe();
    }

    /**
     * Méthode à implémenter par les décorateurs concrets afin d'appliquer
     * leur transformation spécifique sur la liste.
     */
    public abstract void decore();
}