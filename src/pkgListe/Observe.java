package pkgListe;

import java.util.ArrayList;
import java.util.List;

public class Observe {
    /** liste des observateurs inscrits */
    private final List<Observateur> observateurs = new ArrayList<>();

    public void ajouterObs(Observateur obs) {
        if (obs != null && !observateurs.contains(obs)) {
            observateurs.add(obs);
        }
    }

    public void supprimerObs(Observateur obs) {
        observateurs.remove(obs);
    }


    public void notifierAllObs() {
        // On travaille sur une copie pour éviter les modifications concurrentes
        List<Observateur> copie = new ArrayList<>(observateurs);
        for (Observateur obs : copie) {
            obs.update();
        }
    }
}