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

        //12-1/2 Diameter Round Wall Clock
        String pattern = "Leather Chair";

        BruteForce bruteForce = new BruteForce();
        bruteForce.SplitPattern(pattern);

        int N=0;
        for(int i=0;i<myArrList.size();i++){
            System.out.print(++N);
            System.out.print("("+bruteForce.Amount_PatternInText(myArrList.get(i))+",");
            System.out.print(bruteForce.First_Pattern_Postion(myArrList.get(i))+",");
            System.out.println(bruteForce.minimumPairDistance(myArrList.get(i),bruteForce.current,bruteForce.current.right,1)+")");
            bruteForce.minimumPairDistance = -1;
        }
    }
}

