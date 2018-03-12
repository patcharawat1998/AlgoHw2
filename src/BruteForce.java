import java.util.ArrayList;

public class BruteForce {

    int minimumPairDistance = -1;
    Node root;
    Node current;

    // Returns the lowest index at which substring pattern begins in text (or else −1).
    //return rule2
    public int findBrute(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();
        int N = 0;
        for (int i = 0; i <= n - m; i++) { // try every starting index within text
            int k = 0; // k is index into pattern
            while (k < m && (text.charAt(i + k) == pattern.charAt(k))) // kth character of pattern matches
            {
                k++;
            }
            if (k == m) { // if we reach the end of the pattern,
                return i; // substring text[i..i+m-1] is a match
            }

        }
        return -1;// search failed
    }

    public void SplitPattern(String pattern) {
        String[] parts = pattern.split(" ");
        if (root == null) {
            Node node = new Node(parts[0]);
            root = node;
            current = root;
        }
        for (int i = 1; i < parts.length; i++) {
            Node node = new Node(parts[i]);
            current.right = node;
            current = node;
        }
        current = root;
    }


    public int minimumPairDistance(String text, Node pattern1, Node pattern2,int x) {
        if (pattern1 != null && pattern2 == null && x ==1) { //x==1 is run first time
            minimumPairDistance = -1;
        } else if (pattern1 == null && pattern2 != null && x ==1) {
            minimumPairDistance = -1;
        }
        else if (pattern1 != null && pattern2 != null) {
            int a = findBrute(text.toUpperCase(), pattern1.pattern.toUpperCase());
            int b = findBrute(text.toUpperCase(), pattern2.pattern.toUpperCase());
            if (a != -1 && b != -1) {//have 2 pattern in text ->Base case
                if (b - a < minimumPairDistance || minimumPairDistance == -1) { //set minimum distance
                    minimumPairDistance = b - a;
                }
            } else if (a != -1 && b == -1) {
                if (pattern2.right != null){
                    minimumPairDistance(text, pattern1, pattern2.right,2);
                }

            } else if (a == -1 && b != -1) {
                if (pattern2.right != null){
                    minimumPairDistance(text, pattern1.right, pattern2.right,2);
                }
            }else if (a == -1 && b ==-1){
                if (pattern2.right == null){
                    minimumPairDistance = -1;
                }else{
                    if(pattern2.right != null && pattern2.right.right != null){
                        minimumPairDistance(text, pattern2.right, pattern2.right.right,2);
                    }
                }
            }
            minimumPairDistance(text, pattern1.right, pattern2.right,2); //another pair
        }

        return minimumPairDistance;
    }

    public int First_Pattern_Postion(String text){
        current = root;
        return findBrute(text.toUpperCase(), current.pattern.toUpperCase());
    }

    public int Amount_PatternInText(String text){
        current = root;
        int N = 0;
        while (current!=null){
            if(findBrute(text.toUpperCase(), current.pattern.toUpperCase())!=-1){
                N++;
            }
            current = current.right;
        }
        return N;
    }


}


