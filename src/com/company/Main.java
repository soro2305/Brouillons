package com.company;

public class Main {

    public static void main(String[] args) {
        Generator generator = new Generator();
        String s1 = generator.generateCode(1000,9999);
        System.out.println("code generer "+s1);
        String saisie = "1234";
        System.out.print("Proposition : "+saisie+" -> Réponse : ");

        for (int i = 0; i < saisie.length(); i++) {
            for (int i2 = 0; i < s1.length(); i++) {
                int b = Character.getNumericValue(s1.charAt(i)) ;
          int a = Character.getNumericValue(saisie.charAt(i)) ;
          if (a<b){ System.out.print("+"); }
          if (a>b){ System.out.print("-"); }
          if (a==b){ System.out.print("="); }


            }
          //  System.out.println(a);
        }
    }
}