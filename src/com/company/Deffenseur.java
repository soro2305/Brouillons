package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Deffenseur extends Mode {
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
        codeUser = deffObj1.define();
        //Définition 1 er combinaison Ordi
        codeOrdi = deffObj1.generateCode(min, max);
        //Boucle paramètre le nombres de tentatives via la var int tours
        for (i = 0; i <= m; i++) {
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

                codeOrdi = deffObj1.newCodeOrdiFinal(codeOrdi, codeUser);
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

    public String newCodeOrdiTempo(String codeOrdi1, String codeUser1) {
        //Initialisation Objets variables
        Deffenseur deffObj = new Deffenseur();
        int unitPlusHaut = 0;
        int unitPlusBas = 0;
        int nombreUnit = 4;
        //Array pr stocker current en int et combi final en String
        int[] previousCode = new int[nombreUnit];//Stocke ancien code int
        int[] stockCode = new int[nombreUnit];//Stocke news code int
        String newCode[] = new String[stockCode.length];//Stocke news code int
        //Reponse final format String
        String newCodeString = "";
        //Deux boucles pour séparés caractères des code Ordi et User
        for (int i = 0; i < codeOrdi1.length(); i++) {
            for (int i2 = 0; i < codeUser1.length(); i++) {
                //Stockage de ses caractères dans des var int
                int unitCodeUser = Character.getNumericValue(codeUser1.charAt(i));
                int unitCodeOrdi = Character.getNumericValue(codeOrdi1.charAt(i));
                //Conditions pour comparer si les futur unités combi Ordi doivent êtres "-+="
                if (unitCodeUser < unitCodeOrdi) {
                    previousCode[i] = unitCodeOrdi;//Stocke ancien code
                    //Boucle génére nouvelle unité tant que plus haute que précédente
                    do {
                        //Méthode random génére news units.Borne max ordi -1 pr évité les doublons
                        unitPlusBas = deffObj.generCodeInt(0, (unitCodeOrdi - 1));
                    } while (unitPlusBas > unitCodeOrdi);
                    stockCode[i] = unitPlusBas;//Stocke news code
                }
                //Boucle génére nouvelle unité tant que plus basse que précédente
                if (unitCodeUser > unitCodeOrdi) {
                    previousCode[i] = unitCodeOrdi;//lR[i]=e;
                    do {
                        //Méthode random génére news units.Borne min ordi +1 pr évité les doublons
                        unitPlusHaut = deffObj.generCodeInt((unitCodeOrdi + 1), 9);
                    } while (unitPlusHaut < unitCodeOrdi);
                    stockCode[i] = unitPlusHaut;
                }
                //Génére unité égales
                if (unitCodeUser == unitCodeOrdi) {
                    previousCode[i] = unitCodeOrdi;
                    stockCode[i] = deffObj.generCodeInt(unitCodeOrdi, unitCodeOrdi);
                }
            }
        }

        //   Transforme int array en string array
        for (int j = 0; j < stockCode.length; j++) {
            newCode[j] = String.valueOf(stockCode[j]);
        }
        //Transforme array String en String
        newCodeString = Deffenseur.ArrayToString(newCode);
        //retour nouvelle combinaison en String
        return newCodeString;
    }

    public String newCodeOrdiFinal(String codeOrdi1, String codeTempo) {
        //Initialisation Objets variables
        Deffenseur deffObj = new Deffenseur();
        int unitPlusHaut = 0;
        int unitPlusBas = 0;
        int nombreUnit = 4;
        //Array pr stocker current en int et combi final en String
        int[] previousCode = new int[nombreUnit];//Stocke ancien code int
        int[] stockCode = new int[nombreUnit];//Stocke news code int
        String newCode[] = new String[stockCode.length];//Stocke news code int
        //Reponse final format String
        String newCodeString = "";
        //Deux boucles pour séparés caractères des code Ordi et User
        for (int i = 0; i < codeOrdi1.length(); i++) {
            for (int i2 = 0; i < codeTempo.length(); i++) {
                //Stockage de ses caractères dans des var int
                int unitCodeUser = Character.getNumericValue(codeTempo.charAt(i));
                int unitCodeOrdi = Character.getNumericValue(codeOrdi1.charAt(i));
                //Conditions pour comparer si les futur unités combi Ordi doivent êtres "-+="
                if (unitCodeUser < unitCodeOrdi) {
                    previousCode[i] = unitCodeOrdi;//Stocke ancien code
                    //Boucle génére nouvelle unité tant que plus haute que précédente
                    do {
                        //Méthode random génére news units.Borne max ordi -1 pr évité les doublons
                        unitPlusBas = deffObj.generCodeInt(1, (unitCodeOrdi - 1));
                    } while (unitPlusBas > unitCodeOrdi);
                    stockCode[i] = unitPlusBas;//Stocke news code
                }
                //Boucle génére nouvelle unité tant que plus basse que précédente
                if (unitCodeUser > unitCodeOrdi) {
                    previousCode[i] = unitCodeOrdi;//lR[i]=e;
                    do {
                        //Méthode random génére news units.Borne min ordi +1 pr évité les doublons
                        unitPlusHaut = deffObj.generCodeInt((unitCodeOrdi + 1), unitCodeUser);
                    } while (unitPlusHaut < unitCodeOrdi);
                    stockCode[i] = unitPlusHaut;
                }
                //Génére unité égales
                if (unitCodeUser == unitCodeOrdi) {
                    previousCode[i] = unitCodeOrdi;
                    stockCode[i] = deffObj.generCodeInt(unitCodeOrdi, unitCodeOrdi);
                }
            }
        }

        //   Transforme int array en string array
        for (int j = 0; j < stockCode.length; j++) {
            newCode[j] = String.valueOf(stockCode[j]);
        }
        //Transforme array String en String
        newCodeString = Deffenseur.ArrayToString(newCode);
        //retour nouvelle combinaison en String
        return newCodeString;
    }

    //Génére news combi String
    public String generateCode(int min, int max) {
        int newCode = r.nextInt((max - min) + 1) + min; //Classe Random utiliser pour définir les bornes max min de la combinaison
        String newCodeString = Integer.toString(newCode); //Conversion de la combi en string
        return newCodeString; //Retour combinaison
    }

    //Génére news unit int
    public int generCodeInt(int min, int max) {
        int newsUnit = r.nextInt((max - min) + 1) + min; //Classe Random utiliser pour définir les bornes max min de la combinaison
        return newsUnit; //Retour combinaison
    }

    //Méthode qui converti un Array de String en String
    public static String ArrayToString(String[] strArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            stringBuilder.append(strArray[i]);
        }
        return stringBuilder.toString();
    }

    //Méthode définie combinaison User
    public String define() {
        Scanner input = new Scanner(System.in);
        System.out.println("Veuillez définir votre combinaison");
        return input.nextLine();// Retourne saisie du Scanner
    }

}