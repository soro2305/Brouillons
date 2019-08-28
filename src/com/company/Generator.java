package com.company;

import java.util.Random;

public class Generator {

  //  int a = gen1.generateCode(1000, 9999);//====Methode génére la combinaison de l'EA====

    public  String generateCode(int min, int max) {
        Random r = new Random();
        int a = r.nextInt((max - min) + 1) + min;
        String s1 = Integer.toString(a);
        return s1;
    }
}
