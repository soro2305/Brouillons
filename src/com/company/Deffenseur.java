package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Deffenseur extends Player {
    //Defini le nombres de chiffre de combi
    int max = 9999;
    int min = 1000;

    //Methode principale de defender
    public void defender() {
        //Initialisations des instances

        Deffenseur deffObj1 = new Deffenseur();
        Menu menuObj1 = new Menu();
        String codeUser = "";
        String codeOrdi = "";
        String codeTempo = "";
        int tours = 20;//Nombres de tours de la partie
        int rejouer = 0;
        int i;
        System.out.println("Bienvenu dans le mode Déffenseur! ");
        //Définition combinaison utilisateur
        codeUser = deffObj1.defineCodeUser();
        //Définition 1 er combinaison Ordi
        codeOrdi = deffObj1.generCodeString(min, max);
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
                deffObj1.compare(codeOrdi, codeUser);
                //Méthode pour générer nouvelle combinaison Ordi

                codeOrdi = deffObj1.newCodeOrdi(codeOrdi, codeUser);
                System.out.println("\n");
                //Affiche Game over quand nombres de tours épuisés
                if (i == tours) {
                    System.out.println("\n\n\n\n\n\n\n ============== GAME OVER ============== \n");
                }

            }
        }
        //Envoie au menu final
        rejouer = menuObj1.endMenu();
        if (rejouer == 1) deffObj1.defender(); //Condition pour relancer mÃªme mode

    }











}