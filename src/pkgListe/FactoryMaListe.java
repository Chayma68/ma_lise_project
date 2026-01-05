package pkgListe;

/**
 * Fabrique pour créer des instances de MaListe selon différents modes.
 * Implémente le motif Factory Method en renvoyant la bonne variante
 * en fonction du paramètre passé.
 */
public class FactoryMaListe {
    /**
     * Retourne une instance de MaListe selon le paramètre fourni.
     * Les valeurs possibles sont :
     * <ul>
     *   <li>"sanszero" : MaListe supprimant les zéros</li>
     *   <li>"trieeinsertion" : MaListe triée par insertion</li>
     *   <li>"trieeechange" : MaListe triée par échange</li>
     *   <li>"sansdoublons" : MaListe supprimant les doublons</li>
     *   <li>"trieeinsertion_sansdoublons" : MaListe triée par insertion et sans doublons</li>
     *   <li>"trieeechange_sansdoublons" : MaListe triée par échange et sans doublons</li>
     *   <li>toute autre valeur : MaListe simple</li>
     * </ul>
     *
     * @param par le paramètre indiquant le type de liste désiré
     * @return une instance de MaListe correspondante
     */
    public static MaListe getMaListe(String par) {
        if (par == null) {
            return new MaListe();
        }
        String p = par.toLowerCase();
        switch (p) {
            case "sanszero":
                return new MaListeSansZero();
            case "trieeinsertion":
                return new DecMaListeTriee(new MaListe(), new StrategieTriInsertion());
            case "trieeechange":
                return new DecMaListeTriee(new MaListe(), new StrategieTriEchange());
            case "sansdoublons":
                return new DecMaListeSansDoublons(new MaListe());
            case "trieeinsertion_sansdoublons":
                // Combinaison : tri + suppression de doublons
                return new DecMaListeSansDoublons(new DecMaListeTriee(new MaListe(), new StrategieTriInsertion()));
            case "trieeechange_sansdoublons":
                return new DecMaListeSansDoublons(new DecMaListeTriee(new MaListe(), new StrategieTriEchange()));
            default:
                return new MaListe();
        }
    }
}