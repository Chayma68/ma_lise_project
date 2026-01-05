package pkgListe;

/**
 * Implémentation d'une liste chaînée simple.
 * Cette classe fournit des opérations de base permettant de manipuler
 * une séquence d'entiers via des éléments chaînés.
 */
public class Liste {

    private ElementListe premier;

    public boolean estVide() {
        return premier == null;
    }

    public void ajouterAuDebut(int val) {
        ElementListe nouveau = new ElementListe(val);
        nouveau.setSuivant(premier);
        premier = nouveau;
    }

    public boolean contient(int val) {
        for (ElementListe courant = premier; courant != null; courant = courant.getSuivant()) {
            if (courant.getValeur() == val) {
                return true;
            }
        }
        return false;
    }

    public void ajouterALaFin(int val) {
        ElementListe nouveau = new ElementListe(val);
        if (premier == null) {
            premier = nouveau;
        } else {
            ElementListe courant = premier;
            while (courant.getSuivant() != null) {
                courant = courant.getSuivant();
            }
            courant.setSuivant(nouveau);
        }
    }

    public ElementListe getPremier() {
        return premier;
    }

    public ElementListe getDernier() {
        if (premier == null) {
            return null;
        }
        ElementListe courant = premier;
        while (courant.getSuivant() != null) {
            courant = courant.getSuivant();
        }
        return courant;
    }

    public int getLongueur() {
        int count = 0;
        for (ElementListe courant = premier; courant != null; courant = courant.getSuivant()) {
            count++;
        }
        return count;
    }

    public ElementListe supprimerPremier() {
        if (premier == null) {
            return null;
        }
        ElementListe el = premier;
        premier = premier.getSuivant();
        el.setSuivant(null);
        return el;
    }


    public ElementListe supprimerDernier() {
        if (premier == null) {
            return null;
        }
        if (premier.getSuivant() == null) {
            ElementListe el = premier;
            premier = null;
            return el;
        }
        ElementListe courant = premier;
        ElementListe precedent = null;
        while (courant.getSuivant() != null) {
            precedent = courant;
            courant = courant.getSuivant();
        }
        // courant est le dernier élément
        precedent.setSuivant(null);
        return courant;
    }
}