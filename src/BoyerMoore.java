import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {

    public int minimumPairDistance = 6969;
    Node root;
    Node current;

    public BoyerMoore(){

    }
    
    public void SplitPattern(String pattern) {
        String[] parts = pattern.split("\\s+");
        ArrayList<String> temp = new ArrayList<String>();
        for(int i =0;i<parts.length;i++){
            if(!parts[i].isEmpty()){
                temp.add(parts[i]);
            }
        }

            if (root == null) {
                Node node = new Node(temp.get(0));
                root = node;
                current = root;
            }
            for (int i = 1; i < temp.size(); i++) {
                Node node = new Node(temp.get(i));
                current.next = node;
                current = node;
            }
            current = root;

    }


    public int minimumPairDistance(String text, Node pattern1, Node pattern2,int x) {
        if (pattern1 != null && pattern2 == null && x ==1) { //x==1 is run first time
            minimumPairDistance = 6969;
        } else if (pattern1 == null && pattern2 != null && x ==1) {
            minimumPairDistance = 6969;
        }
        else if (pattern1 != null && pattern2 != null) {
            int a = findBoyerMoore(text.toUpperCase(), pattern1.pattern.toUpperCase());
            int b = findBoyerMoore(text.toUpperCase(), pattern2.pattern.toUpperCase());
            if (a != 6969 && b != 6969) {//have 2 pattern in text ->Base case
                if (Math.abs(b - a) < minimumPairDistance || minimumPairDistance == 6969) { //set minimum distance
                    minimumPairDistance = Math.abs(b - a);
                }
            } else if (a != 6969 && b == 6969) {
                if (pattern2.next != null){
                    minimumPairDistance(text, pattern1, pattern2.next,2);
                }

            } else if (a == 6969 && b != 6969) {
                if (pattern2.next != null){
                    minimumPairDistance(text, pattern1.next, pattern2.next,2);
                }
            }else if (a == 6969 && b == 6969){
                if (pattern2.next == null){
                    minimumPairDistance = 6969;
                }else{
                    if(pattern2.next != null && pattern2.next.next != null){
                        minimumPairDistance(text, pattern2.next, pattern2.next.next,2);
                    }
                }
            }
            minimumPairDistance(text, pattern1.next, pattern2.next,2); //another pair
        }

        return minimumPairDistance;
    }

    public int firstPattern_Position(String text){
        current = root;
        int lessfirstPattern_Position = findBoyerMoore(text.toUpperCase(), current.pattern.toUpperCase());
        current = current.next;
        while (current!=null){
            int temp = findBoyerMoore(text.toUpperCase(), current.pattern.toUpperCase());
            if(temp < lessfirstPattern_Position){
                lessfirstPattern_Position = temp;
            }
            current = current.next;
        }
        current = root;
        return lessfirstPattern_Position;
    }

    public int Amount_PatternInText(String text){
        current = root;
        int N = 0;
        while (current!=null){
            if(findBoyerMoore(text.toUpperCase(), current.pattern.toUpperCase())!=6969){
                N++;
            }
            current = current.next;
        }
        current = root;
        return N;
    }


     public  int findBoyerMoore(String text, String pattern) {
         int n = text.length();
         int m = pattern.length();
         if (m == 0) return 0; // trivial search for empty string
         Map<Character,Integer> last = new HashMap<>(); // the 'last' map
         for (int i=0; i < n; i++)
             last.put(text.charAt(i), -1); // set −1 as default for all text characters
         for (int k=0; k < m; k++)
             last.put(pattern.charAt(k), k); // rightmost occurrence in pattern is last
         // start with the end of the pattern aligned at index m−1 of the text
         int i = m-1; // an index into the text
         int k = m-1; // an index into the pattern
         while (i < n) {
             if (text.charAt(i) == pattern.charAt(k)) { // a matching character
                 if (k == 0) return i; // entire pattern has been found
                 i--; // otherwise, examine previous
                 k--; // characters of text/pattern
                 } else {
                 i += m - Math.min(k, 1 + last.get(text.charAt(i))); // case analysis for jump step
                 k = m - 1; // restart at end of pattern
                 }
             }
         return 6969; // pattern was never found
         }
}


