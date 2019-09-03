package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Deffenseur extends Mode {
    int max = 9999;
    int min = 1000;
    List<String> lC = new ArrayList();
    static    int lR[]=new int[9];
    public void defender() {
        //Initialisations des instances
        Deffenseur obj = new Deffenseur();
        Menu obj1 = new Menu();

        String sP = "";
        String sE;
        int m = 20;
        int a = 0;
        int i;
        System.out.println("Bienvenu dans le mode Déffenseur! ");
        //Définition combinaison utilisateur
        sP = obj.define();
        sE = obj.generateCode(min, max);
        //Boucle paramétre le nombre de tentative via la var "m"
        for (i = 0; i <= m; i++) {

            if (sE.equals(sP)) {
                System.out.println("GAME OVER l'EA a trouver la solution  " + sP + " !!!\n\n\n\n\n ");//Conditions pour quitter la boucle si victoire de l'EA
                break;
            } else {

                System.out.print("Proposition : " + sE + " -> Réponse : ");
                //Méthode pour comparer les deux combinaisons
                obj.compare(sE, sP);

                sE = obj.generateNew(sE, sP);


                System.out.println("\n");
                if (i == m) {
                    System.out.println("\n\n\n\n\n\n\n ============== GAME OVER ============== \n");
                }

            }
        }
        //Envoie au menu final
        a = obj1.endMenu();
        if (a == 1) obj.defender(); //Condition pour relancer même mode

    }

    public String generateNew(String sE, String sP) {
        Deffenseur obj = new Deffenseur();
        List<String> lS = new ArrayList();
        List<Integer> lA = new ArrayList();
        int g = 0;
        int h = 0;

        int aPcd[] = new int[4];
        int aStk[] = new int[4];
        String aFnl[] = new String[aStk.length];
        boolean b = true;
        String newSe = "";
        //   List<String> lC = new ArrayList();


        //Deux boucles pour convertir chaque caractères des args en int.
        for (int i = 0; i < sE.length(); i++) {
            for (int i2 = 0; i < sP.length(); i++) {

                int p = Character.getNumericValue(sP.charAt(i));
                int e = Character.getNumericValue(sE.charAt(i));
                // System.out.print(e);
                //Conditions pour comparer et définir l'indication à retourner
                if (p < e) {
                    // lC.add(Integer.toString(e - 1));
                       aPcd[i]=e;//lR[i]=e;
                    do {
                         g  = obj.generateCode2(1, (e - p));

                    } while (h>e) ;                                            //        (aPcd[i] > aStk[i]);
                    aStk[i] = g;
                    // && (aStk[i] != lR[i]));
                    //    lR.add(obj.generateCode2(1,(e-1)));
                    // }while (lA.get(i)<lR.get(i));
                }
                if (p > e) {
                    aPcd[i] = e;//lR[i]=e;
                    do {
                      h = obj.generateCode2((e + 1), p);
                    } while     (h<e) ;                                           //(aPcd[i] < aStk[i]);
                    aStk[i]=h;
                    // && (aStk[i] != lR[i]));
                    // lC.add(Integer.toString(e + 1));
//                    lA.add(e);
//                    do {
//                        lR.add(obj.generateCode2((e+1),9));
//                    }while (lA.get(i)>lR.get(i));
                }
                if (p == e) {
                    aStk[i] = e;//lR[i]=e;

                    aStk[i] = obj.generateCode2(e, e);
                }
               // aStk = aPcd;
            }
        }

        //   Transforme int array en string array
        for (int j = 0; j < aStk.length; j++) {
            aFnl[j] = String.valueOf(aStk[j]);
        }
        newSe = Deffenseur.ArrayToString(aFnl);
        aStk= aPcd;
        System.out.println(" constante final "+Deffenseur.ArrayToString(aFnl));
        System.out.println(" constante precedent "+Deffenseur.ArrayToString(aFnl));

        //retour Arraylist
        return newSe;
    }

    public int generateCode2(int min, int max) {


        int a = r.nextInt((max - min) + 1) + min; //Classe Random utiliser pour définir les bornes max min de la combinaison
        // String c = Integer.toString(a); //Conversion de la combi en string
        return a; //Retour combinaison
    }

    public static String ArrayToString(String[] strArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            stringBuilder.append(strArray[i]);
        }
        return stringBuilder.toString();
    }
}