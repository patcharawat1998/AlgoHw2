import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {

        while (true) {
            int GoodsListWanted;
            if (args.length > 0) {
                GoodsListWanted = Integer.parseInt(args[0]);
            } else {
                GoodsListWanted = 10;
            }


//            Scanner Sc = new Scanner(System.in);
//            System.out.print("Product Search - Input your keyword (s):");
//            String s = Sc.nextLine();


            String pattern;
            Scanner Sc = new Scanner(System.in);
            do {
                Sc = new Scanner(System.in);
                System.out.print("Product Search - Input your keyword (s):");
                pattern = Sc.nextLine();

            }while(pattern.isEmpty());


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

            //String pattern = s;

            BruteForce bruteForce = new BruteForce();
            bruteForce.SplitPattern(pattern);
            RadixSort r = new RadixSort();

            Node key[] = new Node[myArrList.size()];


            int N = 0;
            int find = 0;

            for (int i = 0; i < myArrList.size(); i++) {
                int a = bruteForce.Amount_PatternInText(myArrList.get(i));//rule1
                //System.out.print("("+a+",");
                int b = bruteForce.firstPattern_Position(myArrList.get(i));//rule2
                //System.out.print(b+",");
                int c = bruteForce.minimumPairDistance(myArrList.get(i), bruteForce.current, bruteForce.current.next, 1);
                N++;
                if(a!=0){
    //                System.out.print(++R+"->"+N+"->");
    //                System.out.print("("+a+",");
    //                System.out.print(b+",");
    //                System.out.println(c+")");
    //                //r.AddNode(myArrList.get(i),a,b,c);
                    find++;
                    //System.out.println(find+"-->"+myArrList.get(i));
                }
                bruteForce.minimumPairDistance = 6969;

                r.AddNode(myArrList.get(i), a, b, c, N);
            }


            r.radixSort(3);
            r.radixSort(2);
            r.radixSort(1);
            r.printGoods(GoodsListWanted,find);

            System.out.println(find+" product(s) matched");



//            int h=0;
//            r.current3 = r.root3;
//            while (r.current3 != null){
//                System.out.println(++h+"-->"+r.current3.pattern+"--("+r.current3.rule1+","+r.current3.rule2+","+r.current3.rule3+")");
//                r.current3 = r.current3.next;
//            }

        }
    }
}

