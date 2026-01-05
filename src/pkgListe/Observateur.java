package pkgListe;

/**
 * Interface Observateur pour le motif Observer.
 * Un observateur doit implémenter une méthode update() qui sera appelée
 * lorsqu'un événement est déclenché par le sujet observé.
 */
public interface Observateur {
    /**
     * Méthode invoquée lorsque le sujet notifie ses observateurs.
     */
    void update();
}