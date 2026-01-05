package pkgListe;

/**
 * Interface représentant une stratégie de tri.
 * Permet de définir dynamiquement l'algorithme de tri employé par
 * un décorateur de liste.
 */
public interface StrategieTri {
    /**
     * Trie la liste fournie selon un algorithme spécifique.
     *
     * @param liste la liste à trier
     */
    void trier(MaListe liste);
}