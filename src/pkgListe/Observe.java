package pkgListe;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe sujet pour le motif Observateur (Observer).
 * Maintient une liste d'observateurs et notifie ceux-ci lorsque des
 * événements surviennent.
 */
public class Observe {
    /** liste des observateurs inscrits */
    private final List<Observateur> observateurs = new ArrayList<>();

    /**
     * Ajoute un nouvel observateur à la liste.
     *
     * @param obs l'observateur à ajouter
     */
    public void ajouterObs(Observateur obs) {
        if (obs != null && !observateurs.contains(obs)) {
            observateurs.add(obs);
        }
    }

    /**
     * Supprime un observateur de la liste.
     *
     * @param obs l'observateur à retirer
     */
    public void supprimerObs(Observateur obs) {
        observateurs.remove(obs);
    }

    /**
     * Notifie tous les observateurs inscrits en appelant leur méthode update().
     */
    public void notifierAllObs() {
        // On travaille sur une copie pour éviter les modifications concurrentes
        List<Observateur> copie = new ArrayList<>(observateurs);
        for (Observateur obs : copie) {
            obs.update();
        }
    }
}