package com.company;

import com.joueurs.Player;
import com.joueurs.User;

public class Mode extends Player{
    User menuObj1 = new User();

    public void attaque() {
    //Initialisations des instances
    String codeUser = "0" ; String codeOrdi;
    int  tours = 3;
    int rejouer = 0;
    //conteurs for loop
    int i;int j;

    //Création combinaison EA
    codeOrdi = generCodeString(1000,9999);
    System.out.println("Bienvenu dans le mode challenger! ");

    //Boucle paramétre le nombre de tentative via la var "m"
    for (  i = 0 ; i <= tours  ; i ++ ) {
        codeUser = defineCodeUser();
        if (codeUser.equals(codeOrdi)){System.out.println("Bravo c est Gagné la solution etait " +codeOrdi+ " !!!\n\n\n\n\n ");//Conditions pour quitter la boucle si victoire
            break;
        }else {

            //Méthode pour comparer les deux combinaisons
            System.out.println("Mode Dev L'EA a choisie : "+codeOrdi);
            System.out.print("Proposition : "+codeUser+" -> Réponse : ");
            compare(codeUser, codeOrdi);

            System.out.println("\n");
            if (i == tours){System.out.println("\n\n\n\n\n\n\n ============== GAME OVER ============== \n");}

        }
    }
    //Envoie au menu final

    rejouer = menuObj1.endMenuUser();
    if (rejouer==1)attaque(); //Condition pour relancer même mode
}

        //Methode principale de defender
        public void defender() {
            //Initialisations des instances
            int max = 9999;
            int min = 1000;
            User menuObj1 = new User();
            String codeUser = "";
            String codeOrdi = "";
            String codeTempo = "";
            int tours = 20;//Nombres de tours de la partie
            int rejouer = 0;
            int i;
            System.out.println("Bienvenu dans le mode Déffenseur! ");
            //Définition combinaison utilisateur
            codeUser = defineCodeUser();
            //Définition 1 er combinaison Ordi
            codeOrdi = generCodeString(min, max);
            //Boucle paramètre le nombres de tentatives via la var int tours
            for (i = 0; i <= tours; i++) {
                //Vérifie si les 2 combinaisons sont égales.Stop la partie si true
                if (codeOrdi.equals(codeUser)) {
                    System.out.println("GAME OVER l'EA a trouver la solution  " + codeUser + " !!!\n\n\n\n\n ");//Conditions pour quitter la boucle si victoire de l'EA
                    break;
                } else {
                    //Formate l affichage de sortie console
                    System.out.print("Proposition : " + codeOrdi + " -> Réponse : ");
                    //Méthode pour comparer les deux combinaisons et affiché "+-="
                    compare(codeOrdi, codeUser);
                    //Méthode pour générer nouvelle combinaison Ordi

                    codeOrdi = newCodeOrdi(codeOrdi, codeUser);
                    System.out.println("\n");
                    //Affiche Game over quand nombres de tours épuisés
                    if (i == tours) {
                        System.out.println("\n\n\n\n\n\n\n ============== GAME OVER ============== \n");
                    }

                }
            }
            //Envoie au menu final
            rejouer = menuObj1.endMenuUser();
            if (rejouer == 1) defender(); //Condition pour relancer mÃªme mode

        }

    }

