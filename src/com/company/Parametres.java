package com.company;

import com.joueurs.User;

import java.util.Scanner;

// Classe qui gère les paramètres
public class Parametres extends User {
    //Toutes les variables ayant un impact sur les paramètres
    public static boolean tour = false;
    static int tours = 3;
    static int[] tailleCombi = new int[2];
    static int min = 1000;
    static int max = 9999;
    static boolean devMode = false;
    public static int nombreUnit = 4;

    //Méthode principale de la classe paramètres
    public void settings() {
        Scanner input = new Scanner(System.in);
        System.out.println("Menus paramètres");
        System.out.println("A-Sélections nombres de tours || Actuellement réglés sur --> " + (tours + 1) + " tours");
        System.out.println("B-Sélections chiffres combinaison || Actuellement réglées sur --> " + nombreUnit + " chiffres");
        System.out.println("C-Activé le mode Développeur || Actuellement réglé sur --> " + devMode);
        System.out.println("D-Retour Menu Principal");
        char option = '\1';
        option = input.next().charAt(0); // Initialisation des options afin de récupérer le 1er caractère
        //switch pour définir l'un des choix
        switch (option) {

            case 'A':
                //Définit le nombre de manches
                System.out.println("Veuillez entrer le nombre de tours maximum pour le mode Défenseur et Challenger");
                tours = nombreTour(); //Méthode qui définit le nombre de manches redéfini la var statique tours
                settings();//Retour menu paramètres
                break;
            case 'B':
                System.out.println("Veuillez entrer le nombre de chiffres de la combinaison avec pour niveau : Easy --> 3 || Normal --> 4 || Hard --> 5 ");
                tailleCombi = chiffreCombi();//Méthode qui définit le nombre de chiffres combi redéfini le range min max du générateur de combi
                min = tailleCombi[0];
                max = tailleCombi[1];
                nombreUnit = tailleCombi[2];//Nombre d'unité (chiffres) du générateur
                if (nombreUnit == 3) System.out.println("Niveau Easy Activer !!! \n");
                if (nombreUnit == 4) System.out.println("Niveau Normal Activer !!! \n");
                if (nombreUnit == 5) System.out.println("Niveau Hard Activer !!! \n");
                settings();//Retour menu paramètres
            case 'C':
                System.out.println("Veuillez taper :  1 pour activer le mode Dev || 2 pour désactiver le mode Dev");
                devMode = modeDev();//Méthode qui définit l'activation du mode Dev en assignant true ou false a la var static devMode
                if (devMode == true) System.out.println("Mode Dev Activer !!! \n");
                if (devMode == false) System.out.println("Mode Dev Désactivé !!! \n");
                settings();//Retour menu paramètres
                break;
            case 'D':
                startMenuUser();//Retour menu principal

            default:
                System.out.println("Entrer invalide !");
        }
        System.out.println("\n \n \n ");
    }
    //Méthode qui définit le nombre de manches
    public static int nombreTour() {
        Scanner input = new Scanner(System.in);
        return (input.nextInt() - 1);
    }

    //Méthode qui définit le nombre de chiffres combi
    public static int[] chiffreCombi() {
        Scanner input = new Scanner(System.in);
        int nombres = input.nextInt();
        int[] tailleCombi = new int[3];
        //Array pour définir un range selon l'input de l'utilisateur
        if (nombres == 3) {
            tailleCombi[0] = 100;
            tailleCombi[1] = 999;
            tailleCombi[2] = 3;
        }
        if (nombres == 4) {
            tailleCombi[0] = 1000;
            tailleCombi[1] = 9999;
            tailleCombi[2] = 4;
        }
        if (nombres == 5) {
            tailleCombi[0] = 10000;
            tailleCombi[1] = 99999;
            tailleCombi[2] = 5;
        }
        return tailleCombi;
    }

    //Méthode qui définit l'activation du mode Dev
    public static boolean modeDev() {
        Scanner input = new Scanner(System.in);
        int trueFalse = input.nextInt();
        boolean modeDev = false;
        if (trueFalse == 1) {
            modeDev = true;
        }
        if (trueFalse == 2) {
            modeDev = false;
        }
        return modeDev;
    }
}
