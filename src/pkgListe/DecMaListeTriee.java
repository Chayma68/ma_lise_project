package pkgListe;

/**
 * Décorateur triant une MaListe selon une stratégie donnée.
 * Ce décorateur permet de trier la liste sans modifier la classe MaListe
 * d'origine, en appliquant la stratégie de tri spécifiée.
 */
public class DecMaListeTriee extends DecoratorMaListe {
    /** stratégie de tri utilisée par ce décorateur */
    private StrategieTri strategie;

    /**
     * Construit un décorateur triant la liste avec une stratégie donnée.
     *
     * @param liste     la liste à décorer
     * @param strategie la stratégie de tri à appliquer
     */
    public DecMaListeTriee(MaListe liste, StrategieTri strategie) {
        super(liste);
        this.strategie = strategie;
    }

    /**
     * Définit une nouvelle stratégie de tri.
     *
     * @param strategie la nouvelle stratégie
     */
    public void setStrategie(StrategieTri strategie) {
        this.strategie = strategie;
    }

    /**
     * Trie la liste décorée en utilisant la stratégie actuelle.
     */
    @Override
    public void decore() {
        if (strategie != null) {
            strategie.trier(liste);
        }
    }

    /**
     * Méthode utilitaire exposée pour lancer le tri explicitement.
     */
    public void trierListe() {
        decore();
    }
}