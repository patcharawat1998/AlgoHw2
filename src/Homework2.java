import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {

            while (true) {
                try {
                    int GoodsListWanted;
                    if (args.length > 0) {
                        GoodsListWanted = Integer.parseInt(args[0]);
                    } else {
                        GoodsListWanted = 10;
                    }


                    String pattern;
                    Scanner Sc = new Scanner(System.in);
                    do {
                        Sc = new Scanner(System.in);
                        System.out.print("Product Search - Input your keyword (s):");
                        pattern = Sc.nextLine();

                    } while (pattern.isEmpty());
                    long startTime = System.nanoTime();


                    ArrayList<String> myArrList = new ArrayList<String>();
                    try (BufferedReader fileReader = new BufferedReader(new FileReader("product.txt"))) {
                        String line = null;
                        while ((line = fileReader.readLine()) != null) {
                            myArrList.add(line);
                        }
                    } catch (Exception ex) {

                    }
                    BruteForce bruteForce = new BruteForce();
                    BoyerMoore boyerMoore = new BoyerMoore();
                    KMP kmp = new KMP();

                    boyerMoore.SplitPattern(pattern);//--------------------------------------------------------------------------

                    RadixSort r = new RadixSort();
                    Node key[] = new Node[myArrList.size()];


                    int N = 0;
                    int find = 0;

                    for (int i = 0; i < myArrList.size(); i++) {
                        int a = boyerMoore.Amount_PatternInText(myArrList.get(i));//rule1  //-------------------------------------------------------------------------------------------
                        int b = boyerMoore.firstPattern_Position(myArrList.get(i));//rule2  //-------------------------------------------------------------------------------------------
                        int c = boyerMoore.minimumPairDistance(myArrList.get(i), boyerMoore.current, boyerMoore.current.next, 1);//-------------------------------------------------------------------------------------------
                        N++;
                        if (a != 0) { //find pattern in text
                            find++;
                        }
                        boyerMoore.minimumPairDistance = 6969; //-------------------------------------------------------------------------------------------
                        r.AddNode(myArrList.get(i), a, b, c, N);
                    }


                    r.radixSort(3);
                    r.radixSort(2);
                    r.radixSort(1);
                    r.printGoods(GoodsListWanted, find);

                    System.out.println(find + " product(s) matched");



                    long endTime = System.nanoTime();

                    long duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
                    System.out.println(duration);



                }catch (Exception ex){

                }
            }

    }
}

