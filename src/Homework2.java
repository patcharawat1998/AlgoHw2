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
                //System.out.println(line);
                myArrList.add(line);
            }
        }catch (Exception ex){

        }



//        for (String s : myArrList){
//            System.out.println(s);
//        }
        //System.out.println(myArrList.size()); //size array = 1024

        String pattern = "Leather Chair";

        int o=1;
        BruteForce bruteForce = new BruteForce();
        for (int i=0;i<myArrList.size();i++){
            System.out.println(o+") "+bruteForce.findBrute(myArrList.get(i),pattern));
            o++;
        }



    }
}
