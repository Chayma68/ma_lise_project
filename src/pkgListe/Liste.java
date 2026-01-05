package pkgListe;

import java.util.NoSuchElementException;

/**
 * Implémentation d'une liste chaînée simple.
 * Cette classe fournit des opérations de base permettant de manipuler
 * une séquence d'entiers via des éléments chaînés.
 */
public class Liste {
    /** premier élément de la liste */
    private ElementListe premier;

    /**
     * Vérifie si la liste est vide.
     *
     * @return vrai si aucun élément n'est présent
     */
    public boolean estVide() {
        return premier == null;
    }

    /**
     * Insère un élément en tête de la liste.
     *
     * @param val valeur à insérer
     */
    public void ajouterAuDebut(int val) {
        ElementListe nouveau = new ElementListe(val);
        nouveau.setSuivant(premier);
        premier = nouveau;
    }

    /**
     * Recherche si une valeur est contenue dans la liste.
     *
     * @param val valeur recherchée
     * @return vrai si la valeur est trouvée
     */
    public boolean contient(int val) {
        for (ElementListe courant = premier; courant != null; courant = courant.getSuivant()) {
            if (courant.getValeur() == val) {
                return true;
            }
        }
        return false;
    }

    /**
     * Insère un élément en fin de liste.
     *
     * @param val valeur à insérer
     */
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

    /**
     * Renvoie le premier élément de la liste.
     *
     * @return le premier élément ou null si la liste est vide
     */
    public ElementListe getPremier() {
        return premier;
    }

    /**
     * Renvoie le dernier élément de la liste.
     *
     * @return le dernier élément ou null si la liste est vide
     */
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

    /**
     * Calcule la longueur de la liste.
     *
     * @return le nombre d'éléments présents
     */
    public int getLongueur() {
        int count = 0;
        for (ElementListe courant = premier; courant != null; courant = courant.getSuivant()) {
            count++;
        }
        return count;
    }

    /**
     * Supprime et renvoie le premier élément de la liste.
     *
     * @return l'élément retiré ou null si la liste est vide
     */
    public ElementListe supprimerPremier() {
        if (premier == null) {
            return null;
        }
        ElementListe el = premier;
        premier = premier.getSuivant();
        el.setSuivant(null);
        return el;
    }

    /**
     * Supprime et renvoie le dernier élément de la liste.
     *
     * @return l'élément retiré ou null si la liste est vide
     */
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