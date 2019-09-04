package com.company;

import java.util.Scanner;

public class Menu  {

    public void startMenu (){
        //Initialisation des instances
      //  Challenger choix = new Challenger();
        Deffenseur choix1 = new Deffenseur();
        Deffenseur choix2 = new Deffenseur();
        Scanner input = new Scanner(System.in);
        char option = '\0';



        //===== Menu d accueil ======
        System.out.println("Choisissait une options en tapant la lettre correspondante");
        System.out.println("A-Challenger");
        System.out.println("B-Déffenseur");
        System.out.println("C-Duel");
        System.out.println("D-Paramétres");
        System.out.println("E-Quitter");

        option = input.next().charAt(0); // ===== Initialisation de options afin de recupperer le 1er caractere =======
        System.out.println("\n");
        // Utilisation de switch contient les choix du menu
        switch (option) {
            case 'A'://===== Choix A envoie classe Challenger ======
           //     choix.attaque();
                break;
            case 'B'://====== Choix B envoie classe Defensseur =======
                choix1.defender();
                break;
            case 'C':
                // choix.duo();
                choix2.defender();
                break;
            case 'D':
                //choix.settings();
                break;
            case 'E':
                System.out.println("Vous avez choisi de Quitter");
                break;

            default:
                System.out.println("Entrer invalide ! Essayer encore");
        }



    }

    public int endMenu (){
        Scanner input = new Scanner(System.in);
        Menu choix = new Menu();
        int a = 0;

        //Menu de fin

        System.out.println("Entre une options en tappant la lettre corespondante");
        System.out.println("A-Rejouer même mode");
        System.out.println("B-Retour menu principale");
        System.out.println("C-Quitter l'application");
        char option2 = '\1';
        option2 = input.next().charAt(0); // Initialisation des options afin de récupérer le 1er caractère

        switch (option2) {

            case 'A':  a = 1;//Condition pour relancer même mode

                break;
            case 'B':
                System.out.println("\n \n \n ");
                choix.startMenu();
            case 'C':
                System.out.println("\n \n \n ");
                break;
            default:
                System.out.println("Entrer invalide !");


        }
        System.out.println("\n \n \n ");

        return a;
    }

}
