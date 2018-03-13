import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Homework2 {
    public static void main(String[] args) {

        ArrayList<String> myArrList = new ArrayList<String>();
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

        //12-1/2 Diameter Round Wall Clock
        String pattern = "Leather oo Chair";

        BruteForce bruteForce = new BruteForce();
        bruteForce.SplitPattern(pattern);

        PrepareToSort key[] = new PrepareToSort[myArrList.size()];

        int N=0;
        for(int i=0;i<myArrList.size();i++){
            System.out.print(++N);
            int a = bruteForce.Amount_PatternInText(myArrList.get(i));//rule1
            System.out.print("("+a+",");
            int b = bruteForce.First_Pattern_Postion(myArrList.get(i));//rule2
            System.out.print(b+",");
            int c = bruteForce.minimumPairDistance(myArrList.get(i),bruteForce.current,bruteForce.current.next,1);
            System.out.println(c+")"); //rule3
            bruteForce.minimumPairDistance = 6969;
            key[i] = new PrepareToSort(myArrList.get(i),a,b,c);
        }

//        for (int i=0;i<key.length;i++){
//            System.out.println(key[i].value);
//            System.out.print(key[i].rule1);
//            System.out.print(key[i].rule2);
//            System.out.println(key[i].rule3);
//        }




//        int arr[] = new int[10];
//        int R = 10;

        RadixSort radixSort = new RadixSort();
        radixSort.radixsort(key,myArrList.size());

        for (int i=0;i<key.length;i++){
            System.out.println(key[i].value);
            System.out.print("("+key[i].rule1+",");
            System.out.print(key[i].rule2+",");
            System.out.println(key[i].rule3+")");
        }


    }
}

