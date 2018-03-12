import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Homework2 {
    public static void main(String[] args) {
        ArrayList<String> myArrList = new ArrayList<String>();
        String a;
        String b;
        try (BufferedReader fileReader = new BufferedReader(new FileReader("product.txt"))) {
            String line = null;
            while ((line = fileReader.readLine()) != null) {
                myArrList.add(line);
            }
        } catch (Exception ex) {

        }

//        for (String s : myArrList){
//            System.out.println(s);
//        }
        //System.out.println(myArrList.size()); //size array = 1024

        String pattern = "12 Short Pencils";
        String[] parts = pattern.split(" ");
        ArrayList<String> part = new ArrayList<String>();
        for (int i = 0; i < parts.length; i++) {
            part.add(parts[i]);
        }

        int[] indexBoy = new int[myArrList.size()];
        int[] indexGirl = new int[myArrList.size()];
        int[] minimumPairDistance = new int[myArrList.size()];
        int[] minimumFirstWordPosition = new int[myArrList.size()];
        int[] MainWordinText = new int[myArrList.size()];


        int N = 0;
        int o = 1;
        BruteForce bruteForce = new BruteForce();

        indexBoy[0] = bruteForce.findBrute(myArrList.get(0).toUpperCase(), part.get(0).toUpperCase());
        indexGirl[0] = bruteForce.findBrute(myArrList.get(0).toUpperCase(), part.get(1).toUpperCase());
        minimumPairDistance[0] = indexGirl[0] - indexBoy[0];
        indexBoy[0] = bruteForce.findBrute(myArrList.get(0).toUpperCase(), part.get(1).toUpperCase());
        indexGirl[0] = bruteForce.findBrute(myArrList.get(0).toUpperCase(), part.get(2).toUpperCase());
        if(indexGirl[0] - indexBoy[0] < minimumPairDistance[0]){
            minimumPairDistance[0] = indexGirl[0] - indexBoy[0];
        }



        System.out.println(minimumPairDistance[0]);



//        for (int i = 0; i < 1; i++) {//line by line
//            for (int j = 1; j < part.size()-1; j++) { //in line many word
//                indexBoy[i] = bruteForce.findBrute(myArrList.get(i).toUpperCase(), part.get(j).toUpperCase());
//                indexGirl[i] = bruteForce.findBrute(myArrList.get(i).toUpperCase(), part.get(j + 1).toUpperCase());
//                int v = (indexGirl[j] - indexBoy[j]);
//                if (v < minimumPairDistance[i]) {
//                    minimumPairDistance[i] = v;
//                }
//            }


//            if (indexBoy[i] != -1 && indexGirl[i] != -1) {
//                minimumPairDistance[i] = indexGirl[i] - indexBoy[i];
//                minimumFirstWordPosition[i] = indexBoy[i];
//                MainWordinText[i] = 2;
//
//                System.out.println(o+") "+ myArrList.get(i)+" ("+MainWordinText[i]+","+minimumFirstWordPosition[i]+","+minimumPairDistance[i]+")");
//                N++;
//            }else if(indexBoy[i] != -1 && indexGirl[i] == -1){
//                minimumPairDistance[i] = -1;
//                minimumFirstWordPosition[i] = indexBoy[i];
//                MainWordinText[i] = 1;
//
//                System.out.println(o+") "+ myArrList.get(i)+" ("+MainWordinText[i]+","+minimumFirstWordPosition[i]+","+minimumPairDistance[i]+")");
//
//                N++;
//            }else if(indexBoy[i] == -1 && indexGirl[i] != -1){
//                minimumPairDistance[i] = -1;
//                minimumFirstWordPosition[i] = indexGirl[i];
//                MainWordinText[i] = 1;
//
//                System.out.println(o+") "+ myArrList.get(i)+" ("+MainWordinText[i]+","+minimumFirstWordPosition[i]+","+minimumPairDistance[i]+")");
//                N++;
//            }
//            o++;
//        }
//        System.out.println();
//        System.out.println();
//        System.out.println(N);
//
//        System.out.println(parts.length);


//        BoyerMoore boyerMoore = new BoyerMoore();
//        boyerMoore.findBoyerMoore(myArrList.get(0),pattern);
//        for (int i=0;i<myArrList.size();i++){
//            System.out.println(o+") "+boyerMoore.findBoyerMoore(myArrList.get(i),pattern));
//            o++;
//        }


        }
        //System.out.println(minimumPairDistance[0]);
    }

