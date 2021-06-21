import java.util.Random;

import Algoritmos.heapsort;
import Algoritmos.MergeSort;
import Algoritmos.shellsort;

import java.util.*;

public class Main {


    public static void main(String[] kwargs){

        long[][] times = new long[][] {
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };

        int size = 500;
        for(int p = 0; p<kwargs.length;p++){
            if (kwargs[p].equals("-t")){
                size = Integer.parseInt(kwargs[p+1]);
                
            }
        }
        System.out.println("Starting");
        for(int p = 0; p<3;p++){
            int[][] arrays = new int[][] {
                generateAlmostSorted(size),
                generateRandom(size),
                generateBackwards(size)
            };

            MergeSort ob = new MergeSort();
            

            for(int c = 0; c<3;c++){
                long d0 = System.currentTimeMillis();
                switch(p){
                    case 0:
                        heapsort.sort(arrays[c]);
                        break;
                    case 1:
                        shellsort.sort(arrays[c]);
                        break;
                    case 2:
                        ob.sort(arrays[c], 0, arrays[c].length - 1);
                        break;
                }
                times[p][c] = System.currentTimeMillis() - d0;
            }
        }
        for(int p = 0; p<3;p++){
            for(int c = 0; c<3;c++){
                System.out.printf("%d ",times[p][c]);
            }
            System.out.println("");
        }
        
    }

    public static int[] generateAlmostSorted(int size){
        int[] vector = new int[size];
        for(int p = 0; p<size;p++){
            vector[p] = p+1;
        }
        Random rng = new Random();

        for(int p = 0; p<(size*0.1);p++){
            int item1 = rng.nextInt(size);
            int item2 = rng.nextInt(size);

            int temporary = vector[item1];
            vector[item1] = vector[item2];
            vector[item2] = temporary;
        }

        return vector;
    }

    public static int[] generateRandom(int size){
        int[] vector = new int[size];
        for(int p = 0; p<size;p++){
            vector[p] = p+1;
        }
        Random rng = new Random();

        for(int p = 0; p<size*2;p++){
            int item1 = rng.nextInt(size);
            int item2 = rng.nextInt(size);

            int temporary = vector[item1];
            vector[item1] = vector[item2];
            vector[item2] = temporary;
        }

        return vector;
    }

    public static int[] generateBackwards(int size){
        int[] vector = new int[size];
        for(int p = 0; p<size;p++){
            vector[p] = size-p;
        }
        return vector;
    }
}