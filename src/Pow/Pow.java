package Pow;

import java.util.ArrayList;

public class Pow {
    static long[][] pow = new long[10][10];
    static {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                pow [i][j] =(long) Math.pow(i, j);
                // System.out.print( pow[i][j]+ "   ");
            }
            // System.out.println();
        }
    }

    static ArrayList<Integer> cifri = new ArrayList<Integer>();// массив с цыфрами числа
    static void quality(long i){
        ArrayList<Integer> cifri = new ArrayList<Integer>();

        Integer ost = 0;
        while(i > 0){
            ost = (int)(i % 10);

            i = i/10;
            cifri.add(cifri.size(),ost);
        }
        System.out.println(cifri);
       // return cifri;
    }



    public static void main(String[] args) {
       // System.out.println(pow[9][9]);
        //Nen cfv rjl ghj j,hf,jnre wsah
    }
}
