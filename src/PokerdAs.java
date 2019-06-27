
import java.util.Arrays;

public class PokerdAs {

    public static void main(String[] args) {


        int[] tirage = new int[5];
//        tirage[0]=1;
//        tirage[1]=1;
//        tirage[2]=2;
//        tirage[3]=3;
//        tirage[4]=4;
        String[] etat = new String[4];
        int paire = 0;
        int doublePaire = 0;
        int brelan = 0;
        int carre = 0;
        int full = 0;
        int petiteSuite = 0;
        int grandeSuite = 0;
        int poker = 0;
        int rien = 0;

        int successif = 0;
        int egal = 0;
        int neutre = 0;
        int doubleEgalite = 0;


        for (int i = 0; i < 5; i++) {
            tirage[i] = (int) (Math.random() * 6 + 1);

        }
        java.util.Arrays.sort(tirage);
        for (int i = 0; i < 5; i++) {
            System.out.print(tirage[i] + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println();


        // on détermine si les chiffres sont successifs, sont égaux, ou aucun des deux
        for (int j = 0; j < tirage.length - 1; j++) {
            if (tirage[j] == tirage[j + 1]) {
                etat[j] = "egal";
                egal = egal + 1;

            } else if (tirage[j] + 1 == tirage[j + 1]) {
                etat[j] = "successif";
                successif = successif + 1;
            } else {
                etat[j] = "neutre";
                neutre = neutre + 1;
            }
//            System.out.println(etat[j]);

        }

        for (int k = 0; k < 3; k++) {
            if (etat[k] == "egal" && etat[k + 1] == "egal") {  // on note si on a deux égalités à la suite
                doubleEgalite = doubleEgalite + 1;

            }

        }


        for (int k = 0; k < tirage.length; k++) {
            // Pour une paire on a un unique état "egal" ;)
            if (egal == 1) {
                paire = 1;
            }

            // Pour une double paire on a deux états 'egal" mais qui ne se suivent pas
            if (egal == 2 && doubleEgalite == 0) {
                doublePaire = 1;
            }
            // Pour un brelan, on a deux états "egal" qui se suivent
            if (egal == 2 && doubleEgalite == 1) {
                brelan = 1;
            }

            // Pour un carré on a trois états 'egal qui se suivent
            if (egal == 3 && doubleEgalite == 2) {
                carre = 1;
            }

            // Pour une petite suite
            if (successif == 3 && (etat[0]=="neutre" || etat[3] == "neutre" || egal==1 ) ) {
                petiteSuite = 1;
                paire = 0;
            }

            // Pour une grande suite on a 4 successifs
            if (successif == 4) {
                grandeSuite = 1;
            }

            // Pour un poker on a 4 états à "égal"
            if (egal == 4) {
                poker = 1;
            }
            // Pour un tirage sans rien on a aucune égalité et pas de suite.
            if (egal ==0 && petiteSuite==0 &&grandeSuite==0) {
                rien = 1;
            }

            // Pour un full 3 états à égal et 1 "double égalité"
            if (egal == 3 && doubleEgalite == 1) {
                full = 1;

            }

        }
        // Affiche les résultats
        if (full == 1) {
            System.out.println("Un full");
        }
        if (paire == 1) {
            System.out.println("Une paire");
        }
        if (doublePaire == 1) {
            System.out.println("Une double paire");
        }
        if (brelan == 1) {
            System.out.println("Un brelan");
        }
        if (carre == 1) {
            System.out.println("Un carré");
        }

        if (petiteSuite == 1) {
            System.out.println("Une petite suite");
        }
        if (grandeSuite == 1) {
            System.out.println("Une grande suite");
        }
        if (poker == 1) {
            System.out.println("Un poker");
        }
        if (rien == 1) {
            System.out.println("Rien");
        }

    }
}