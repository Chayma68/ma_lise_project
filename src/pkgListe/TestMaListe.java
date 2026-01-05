package pkgListe;

/**
 * Classe de test pour démontrer l'utilisation des différents motifs sur MaListe.
 */
public class TestMaListe {
    public static void main(String[] args) {
        System.out.println("*** Test de MaListe normale ***");
        MaListe liste = FactoryMaListe.getMaListe("normal");
        SommeListeObs sommeObs = new SommeListeObs(liste);
        ProduitListeObs produitObs = new ProduitListeObs(liste);
        // ajout des observateurs
        liste.ajouterObs(sommeObs);
        liste.ajouterObs(produitObs);

        // opérations sur la liste
        liste.push(3);
        liste.push(0);
        liste.push(5);
        liste.push(2);
        // affichage
        liste.afficher();
        // dépilage
        liste.pop();
        liste.afficher();

        System.out.println("\n*** Test de MaListeSansZero ***");
        MaListe sansZero = FactoryMaListe.getMaListe("sanszero");
        sansZero.ajouterObs(new SommeListeObs(sansZero));
        sansZero.push(0);
        sansZero.push(7);
        sansZero.push(0);
        sansZero.push(4);
        sansZero.afficher();
        ((MaListeSansZero) sansZero).EliminerZero();
        sansZero.afficher();

        System.out.println("\n*** Test de tri par insertion ***");
        MaListe trieeInsertion = FactoryMaListe.getMaListe("trieeinsertion");
        trieeInsertion.ajouterObs(new SommeListeObs(trieeInsertion));
        trieeInsertion.push(4);
        trieeInsertion.push(2);
        trieeInsertion.push(2);
        trieeInsertion.push(5);
        trieeInsertion.push(3);
        trieeInsertion.afficher();
        // tri par insertion
        ((DecMaListeTriee) trieeInsertion).trierListe();
        trieeInsertion.afficher();

        System.out.println("\n*** Test de suppression des doublons ***");
        MaListe sansDoublons = FactoryMaListe.getMaListe("sansdoublons");
        sansDoublons.push(4);
        sansDoublons.push(2);
        sansDoublons.push(2);
        sansDoublons.push(5);
        sansDoublons.push(3);
        sansDoublons.push(3);
        sansDoublons.afficher();
        ((DecMaListeSansDoublons) sansDoublons).decore();
        sansDoublons.afficher();
    }
}