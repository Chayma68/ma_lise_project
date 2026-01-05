package pkgListe;

/**
 * Observateur calculant le produit des valeurs présentes dans une MaListe.
 * Lorsqu'il reçoit une notification, il parcourt la liste et affiche le
 * produit des éléments. Si la liste est vide, le produit est défini comme 0.
 */
public class ProduitListeObs implements Observateur {
    /** liste à observer */
    private final MaListe maListe;

    /**
     * Construit un observateur de produit pour la liste passée en paramètre.
     *
     * @param maListe la liste à observer
     */
    public ProduitListeObs(MaListe maListe) {
        this.maListe = maListe;
    }

    @Override
    public void update() {
        int produit = 1;
        boolean vide = true;
        IteratorMaListe it = maListe.getIterator();
        while (it.hasNext()) {
            ElementListe el = it.next();
            produit *= el.getValeur();
            vide = false;
        }
        if (vide) {
            produit = 0;
        }
        System.out.println("Produit des éléments : " + produit);
    }
}