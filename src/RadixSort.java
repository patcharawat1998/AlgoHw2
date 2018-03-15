import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class RadixSort {
     public Node root;
     public Node current;

     public Node root1;
     public Node current1;

     public Node root2;
     public Node current2;

     public Node root3;
     public Node current3;
    public RadixSort(){

    }

    public void AddNode(String value, int rule1, int rule2, int rule3,int ID){
        Node node = new Node(value,rule1,rule2,rule3,ID);
        if (root == null) {
            root = node;
            current = root;
        }else {
            current.next = node;
            current = node;
        }
    }
    public void printGoods(int GoodsListWanted,int find) {
        if (find != 0) {
                int N = 1;
                current3 = root3;
                while (current3 != null && N <= find) {
                    if(N > GoodsListWanted){
                        break;
                    }
                    System.out.println("["+current3.ID+"] "+current3.pattern +" ("+current3.rule1+","+current3.rule2+","+current3.rule3+")");
                    //System.out.println("[ID "+current3.ID+"] "+current3.pattern);
                    //System.out.println("- " + current3.pattern);
                    current3 = current3.next;
                    N++;
                }
        }
    }

    public void radixSort(int rule){

        if(rule == 3){
            current = root;
            ArrayList<Integer> numList = new ArrayList<Integer>();
            //int max = current.rule3;
            while (current != null){
                if(!numList.contains(current.rule3)){
                    numList.add(current.rule3);
                }
                current = current.next;
            }
            int numList2[] = new  int[numList.size()];
            for (int i=0;i<numList2.length;i++){
                numList2[i] = numList.get(i);
            }
            Arrays.sort(numList2);


            for (int i=0;i<numList2.length;i++){
                current = root;
                while (current != null){
                        if(current.rule3 == numList2[i]){
                            SubRadixSort(current,rule);
                        }
                    current = current.next;
                    }
                }
            }else if(rule == 2){
            ArrayList<Integer> numList = new ArrayList<Integer>();
            current1 = root1;
            while (current1 != null){
                if(!numList.contains(current1.rule2)){
                    numList.add(current1.rule2);
                }
                current1 = current1.next;
            }

            int numList2[] = new  int[numList.size()];
            for (int i=0;i<numList2.length;i++){
                numList2[i] = numList.get(i);
            }
            Arrays.sort(numList2);

            for (int i=0;i<numList2.length;i++){
                current1 = root1;
                while (current1 != null){
                    if(current1.rule2 == numList2[i]){
                        SubRadixSort(current1,rule);
                    }
                    current1 = current1.next;
                }
            }
            }else {
            ArrayList<Integer> numList = new ArrayList<Integer>();
            current2 = root2;
            while (current2 != null){
                if(!numList.contains(current2.rule1)){
                    numList.add(current2.rule1);
                }
                current2 = current2.next;
            }
            int numList2[] = new  int[numList.size()];
            for (int i=0;i<numList2.length;i++){
                numList2[i] = numList.get(i);
            }
            Arrays.sort(numList2);
            reverseArray(numList2,0,numList2.length-1);
            for (int i=0;i<numList2.length;i++){
                current2 = root2;
                while (current2 != null){
                    if(current2.rule1 == numList2[i]){
                        SubRadixSort(current2,rule);
                    }
                    current2 = current2.next;
                }
            }
        }
    }

    public void SubRadixSort(Node current,int rule){
        Node node = new Node(current.pattern,current.rule1,current.rule2,current.rule3,current.ID);
        if(rule == 3){
            if(root1 == null){
                root1=node;
                current1=root1;
            }else {
                current1.next = node;
                current1 = node;
            }
        }else if(rule == 2){
            if(root2 == null){
                root2=node;
                current2=root2;
            }else {
                current2.next = node;
                current2 = node;
            }
        }else {
            if(root3 == null){
                root3=node;
                current3=root3;
            }else {
                current3.next = node;
                current3 = node;
            }
        }
    }

    public  void reverseArray(int[ ] data, int low, int high) {
         if (low < high) { // if at least two elements in subarray
             int temp = data[low]; // swap data[low] and data[high]
             data[low] = data[high];
             data[high] = temp;
             reverseArray(data, low + 1, high - 1); // recur on the rest
             }
    }

}
