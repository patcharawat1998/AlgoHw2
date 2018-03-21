import java.util.ArrayList;

public class KMP {
    public int minimumPairDistance = 6969;
    Node root;
    Node current;

    public KMP(){

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
            int a = findKMP(text.toUpperCase(), pattern1.pattern.toUpperCase());
            int b = findKMP(text.toUpperCase(), pattern2.pattern.toUpperCase());
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
        int lessfirstPattern_Position = findKMP(text.toUpperCase(), current.pattern.toUpperCase());
        current = current.next;
        while (current!=null){
            int temp = findKMP(text.toUpperCase(), current.pattern.toUpperCase());
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
            if(findKMP(text.toUpperCase(), current.pattern.toUpperCase())!=6969){
                N++;
            }
            current = current.next;
        }
        current = root;
        return N;
    }

    public  int findKMP(String text, String pattern) {
         int n = text.length();
         int m = pattern.length();
         if (m == 0) return 0; // trivial search for empty string
         int[ ] fail = computeFailKMP(pattern); // computed by private utility
         int j = 0; // index into text
         int k = 0; // index into pattern
         while (j < n) {
             if (text.charAt(j) == pattern.charAt(k)) { // pattern[0..k] matched thus far
                 if (k == m - 1) return j - m + 1; // match is complete
                 j++; // otherwise, try to extend match
                 k++;
                 } else if (k > 0)
                 k = fail[k-1]; // reuse suffix of P[0..k-1]
             else
             j++;
             }
         return 6969; // reached end without match
    }

    private  int[ ] computeFailKMP(String pattern) {
         int m = pattern.length();
         int[ ] fail = new int[m]; // by default, all overlaps are zero
         int j = 1;
         int k = 0;
         while (j < m) { // compute fail[j] during this pass, if nonzero
             if (pattern.charAt(j) == pattern.charAt(k)) { // k + 1 characters match thus far
                 fail[j] = k + 1;
                 j++;
                 k++;
                 } else if (k > 0) // k follows a matching prefix
                 k = fail[k-1];
             else // no match found starting at j
             j++;
             }
         return fail;
    }
}
