package com.company;

import com.joueurs.Player;
import com.joueurs.User;

public class Mode extends Player {
    User userObj = new User();
    int max = 9999;
    int min = 1000;
    static String codeUser = "";
    static String codeOrdi = "1";
    int rejouer = 0;

    //Méthode du mode Challenger
    public void attaque() {
        //Initialisations des instances
        int tours = 3;
        //conteurs for loop
        int i;
        int j;

        //Création combinaison EA
        codeOrdi = generCodeString(min, max);
        //Boucle paramétre le nombre de tentative via la var "m"
        for (i = 0; i <= tours; i++) {
            codeUser = attemptUser();
            if (codeUser.equals(codeOrdi)) {
                System.out.println("Bravo c'est Gagné la solution était " + codeOrdi + " !!!\n\n\n\n\n ");//Conditions pour quitter la boucle si victoire
                break;
            } else {

                //Méthode pour comparer les deux combinaisons
                System.out.println("Mode Dev L'EA a choisie : " + codeOrdi);
                System.out.print("Proposition : " + codeUser + " -> Réponse : ");
                compare(codeUser, codeOrdi);

                System.out.println("\n");
                if (i == tours) {
                    System.out.println("\n ============== GAME OVER ============== ");
                    System.out.println("Vous avez épuisé toutes vos chances. La bonne réponse était "+codeOrdi +"\n");
                }

            }
        }
        //Envoie au menu final

        rejouer = userObj.endMenuUser();
        if (rejouer == 1) attaque(); //Condition pour relancer même mode
    }

    //Méthode du mode Deffenseur
    public void defender() {
        //Initialisations des instances

        int tours = 20;//Nombres de tours de la partie
        //Définition combinaison utilisateur
        codeUser = defineCodeUser();
        //Définition 1 er combinaison Ordi
        codeOrdi = generCodeString(min, max);
        //Boucle paramètre le nombres de tentatives via la var int tours
        for (int i = 0; i <= tours; i++) {
            //Vérifie si les 2 combinaisons sont égales.Stop la partie si true
            if (codeOrdi.equals(codeUser)) {
                System.out.println("GAME OVER l'Ordi a trouvé la solution  " + codeUser + " !!!\n\n\n\n\n ");//Conditions pour quitter la boucle si victoire de l'EA
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
        rejouer = userObj.endMenuUser();
        if (rejouer == 1) defender(); //Condition pour relancer mÃªme mode

    }

    public void duel() {
        String tentativeUser = "2";
        String tentativeOrdi = "3";
        boolean sortie = false;
        int rejouer = 0;
        //Définition combinaison Ordi
        codeOrdi = generCodeString(min, max);
        //Définition tentative Ordi
        tentativeOrdi = generCodeString(min,max);
        System.out.println("Mode dev combi Ordi dévoilait : ");
        System.out.println(codeOrdi+ "\n");
        //Définition combinaison utilisateur
        codeUser = defineCodeUser();

        System.out.println("Votre combinaison est : "+codeUser+"\n");
         do {
            tentativeUser = attemptUser();
            if (tentativeUser.equals(codeOrdi)){
                System.out.println("Bravo la réponse etait : "+codeOrdi+" c'est GAGNÉ !!!");
                sortie = true;
             }else {
                System.out.print("Votre proposition est  " + tentativeUser + " -> Indication : ");
                compare(tentativeUser, codeOrdi);
                System.out.println();
                if (tentativeOrdi.equals(codeUser)) {
                    System.out.println("L'Ordi a trouver : " + codeUser + " GAME OVER !!!");
                    sortie = true;

                }
                System.out.print("La proposition de l'Ordi est  : " + tentativeOrdi + " -> Indication : ");
                compare(tentativeOrdi, codeUser);
                System.out.println();
                tentativeOrdi = newCodeOrdi(tentativeOrdi, codeUser);
            }
        }while (!sortie);
        rejouer = userObj.endMenuUser();
        if (rejouer == 1) duel(); //Condition pour relancer même mode
       }

    }


