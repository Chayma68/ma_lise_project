package pkgListe;

public class ElementListe {
    private int valeur;
    private ElementListe suivant;

    public ElementListe(int valeur) {
        this.valeur = valeur;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public ElementListe getSuivant() {
        return suivant;
    }

    public void setSuivant(ElementListe suivant) {
        this.suivant = suivant;
    }
}