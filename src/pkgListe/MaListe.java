package pkgListe;

/**
 * Classe adaptateur transformant une Liste en structure de pile.
 * Étend Observe afin de pouvoir notifier des observateurs lorsque
 * la structure est modifiée (push/pop).
 */
public class MaListe extends Observe {
    private final Liste liste;

    public MaListe() {
        this.liste = new Liste();
    }

    public void push(int val) {
        liste.ajouterAuDebut(val);

        notifierAllObs();
    }

    public int pop() {
        ElementListe el = liste.supprimerPremier();
        if (el == null) {
            throw new IllegalStateException("La pile est vide");
        }
        notifierAllObs();
        return el.getValeur();
    }


    public boolean estVide() {
        return liste.estVide();
    }


    public void vider() {
        while (!liste.estVide()) {
            liste.supprimerPremier();
        }
        notifierAllObs();
    }

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

    public IteratorMaListe getIterator() {
        return new IteratorMaListe(liste.getPremier());
    }
    protected Liste getListe() {
        return liste;
    }
}