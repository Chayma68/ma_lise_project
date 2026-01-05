package pkgListe;

/**
 * Observateur calculant la somme des valeurs présentes dans une MaListe.
 * Lorsqu'il reçoit une notification, il parcourt la liste et affiche la
 * somme des éléments.
 */
public class SommeListeObs implements Observateur {
    /** liste à observer */
    private final MaListe maListe;

    /**
     * Construit un observateur de somme pour la liste passée en paramètre.
     *
     * @param maListe la liste à observer
     */
    public SommeListeObs(MaListe maListe) {
        this.maListe = maListe;
    }

    @Override
    public void update() {
        int somme = 0;
        IteratorMaListe it = maListe.getIterator();
        while (it.hasNext()) {
            ElementListe el = it.next();
            somme += el.getValeur();
        }
        System.out.println("Somme des éléments : " + somme);
    }
}