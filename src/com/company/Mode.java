package com.company;

import com.joueurs.Player;
import com.joueurs.User;

public class Mode extends Player {
    Parametres settingsObj = new Parametres();
    User userObj = new User();
    int max = settingsObj.max;
    int min = settingsObj.min;
    static String codeUser = "";
    static String codeOrdi = "1";
    int rejouer = 0;

    //Méthode du mode Challenger
    public void challenger() {
        //Initialisations des instances

        int tours = settingsObj.tours ;
        //conteurs for loop
        int i;
        int j;

        //Création combinaison EA
        codeOrdi = generCodeString(min, max);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                              Infos ");
        System.out.println("                 Il y aura en tous "+(tours+1)+" manches");
        System.out.println("            Il y aura "+ settingsObj.nombreUnit + " chiffres par combinaison");
        if (settingsObj.devMode==true) System.out.println("             Mode Dev activé L'EA a choisie : " + codeOrdi);
        System.out.println("                        Bonnes chances !!!");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        //Boucle paramétre le nombre de tentative via la var "m"
        for (i = 0; i <= tours; i++) {
            codeUser = attemptUser();
            if (codeUser.equals(codeOrdi)) {
                System.out.println("\n");
                System.out.println("Bravo c'est Gagné la solution était " + codeOrdi + " !!!\n\n");//Conditions pour quitter la boucle si victoire
                break;
            } else {

                //Méthode pour comparer les deux combinaisons
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
        if (rejouer == 1) challenger(); //Condition pour relancer même mode
    }

    //Méthode du mode Deffenseur
    public void déffenseur() {
        //Initialisations des instances

        int tours = settingsObj.tours;//Nombres de tours de la partie
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                              Infos ");
        System.out.println("                 Il y aura en tous "+(tours+1)+" manches");
        System.out.println("            Il y aura "+ settingsObj.nombreUnit + " chiffres par combinaison");
        System.out.println("                        Bonnes chances !!!");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        //Définition combinaison utilisateur
        codeUser = defineCodeUser();
        //Définition 1 er combinaison Ordi
        codeOrdi = generCodeString(min, max);
        //Boucle paramètre le nombres de tentatives via la var int tours
        for (int i = 0; i <= tours; i++) {
            //Vérifie si les 2 combinaisons sont égales.Stop la partie si true
            if (codeOrdi.equals(codeUser)) {
                System.out.println("\n");
                System.out.println("GAME OVER l'Ordi a trouvé la solution  " + codeUser + " !!!\n\n ");//Conditions pour quitter la boucle si victoire de l'EA
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
                    System.out.println("\n\n\n ============== L'ordi a épuisé toutes ses manches c'est GAGNÉ !!! ============== \n");
                }

            }
        }
        //Envoie au menu final
        rejouer = userObj.endMenuUser();
        if (rejouer == 1) déffenseur(); //Condition pour relancer mÃªme mode

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
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                              Infos ");
        System.out.println("            Il y aura "+ settingsObj.nombreUnit + " chiffres par combinaison");
        if (settingsObj.devMode==true) System.out.println("             Mode Dev activé L'EA a choisie : " + codeOrdi);
        System.out.println("                        Bonnes chances !!!");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        //Définition combinaison utilisateur
        codeUser = defineCodeUser();

        System.out.println("Votre combinaison est : "+codeUser+"\n");
         do {
            tentativeUser = attemptUser();
            if (tentativeUser.equals(codeOrdi)){
                System.out.println("\n");
                System.out.println("Bravo la réponse était : "+codeOrdi+" c'est GAGNÉ !!!");
                sortie = true;
             }else {
                System.out.print("Votre proposition est  " + tentativeUser + " -> Indication : ");
                compare(tentativeUser, codeOrdi);
                System.out.println();
                if (tentativeOrdi.equals(codeUser)) {
                    System.out.println("L'Ordi a trouvé : " + codeUser + " GAME OVER !!!");
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


