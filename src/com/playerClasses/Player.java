package com.playerClasses;

import com.company.Deffenseur;

import java.util.Random;
import java.util.Scanner;

public class  Player {
   Random genere = new Random();
   Scanner saisieUser = new Scanner(System.in);



    //Méthode qui permet à l'utilisateur d'entré une combinaison
    public String defineCodeUser() {
     //   Scanner saisieUser = new Scanner(System.in);
        System.out.println("Veuillez définir votre combinaison");
        return saisieUser.nextLine();// Retourne saisie du Scanner
    }

    //Méthode qui compare les combinaisons users,ordis et donne les signes "=-+"en fonctions
    public void compare(String codeUser, String codeOrdi) {
        //Deux boucles pour convertir chaque caractères des args en int.
        for (int i = 0; i < codeOrdi.length(); i++) {
            for (int i2 = 0; i < codeUser.length(); i++) {
                int b = Character.getNumericValue(codeUser.charAt(i));
                int a = Character.getNumericValue(codeOrdi.charAt(i));
                //Conditions pour comparer et définir l'indication à retourner
                if (a < b) {
                    System.out.print("-");
                }
                if (a > b) {
                    System.out.print("+");
                }
                if (a == b) {
                    System.out.print("=");
                }
            }
        }
    }


}

