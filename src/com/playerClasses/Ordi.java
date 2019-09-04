package com.playerClasses;

import com.company.Deffenseur;

import java.util.Random;

public class Ordi {
    Random genere = new Random();





    //Méthode qui génère un code aléatoire String
    public String generCodeString(int min, int max) {
        int stockReponse = genere.nextInt((max - min) + 1) + min; //Classe Random utiliser pour définir les bornes max min de la combinaison
        String newCode = Integer.toString(stockReponse); //Conversion de la combi en string
        return newCode; //Retour combinaison String
    }
    //Génére news unit int
    public int generCodeInt(int min, int max) {
        int newsUnit = genere.nextInt((max - min) + 1) + min; //Classe Random utiliser pour définir les bornes max min de la combinaison
        return newsUnit; //Retour combinaison
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
    //Méthode qui converti un Array de String en String
    public static String ArrayToString(String[] strArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            stringBuilder.append(strArray[i]);
        }
        return stringBuilder.toString();
    }
}
