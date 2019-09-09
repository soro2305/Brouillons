package com.company;

import com.joueurs.Player;
import com.joueurs.User;

import java.util.ArrayList;
import java.util.List;

public class Challenger extends Player {


    public void attaque() {
        //Initialisations des instances
        Challenger challObj = new Challenger();
        Menu menuObj1 = new Menu();


        String codeUser = "0" ; String codeOrdi;
        int  tours = 3;
        int rejouer = 0;
        //conteurs for loop
        int i;int j;

        //Création combinaison EA
        codeOrdi = challObj.generCodeString(1000,9999);
        System.out.println("Bienvenu dans le mode challenger! ");

        //Boucle paramétre le nombre de tentative via la var "m"
        for (  i = 0 ; i <= tours  ; i ++ ) {
            codeUser = challObj.defineCodeUser();
            if (codeUser.equals(codeOrdi)){System.out.println("Bravo c est Gagné la solution etait " +codeOrdi+ " !!!\n\n\n\n\n ");//Conditions pour quitter la boucle si victoire
                break;
            }else {

                //Méthode pour comparer les deux combinaisons
                System.out.println("Mode Dev L'EA a choisie : "+codeOrdi);
                System.out.print("Proposition : "+codeUser+" -> Réponse : ");
                challObj.compare(codeUser, codeOrdi);

                System.out.println("\n");
                if (i == tours){System.out.println("\n\n\n\n\n\n\n ============== GAME OVER ============== \n");}

            }
        }
        //Envoie au menu final

        rejouer = menuObj1.endMenu();
        if (rejouer==1)challObj.attaque(); //Condition pour relancer même mode
    }
}
