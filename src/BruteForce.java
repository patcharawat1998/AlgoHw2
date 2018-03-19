import java.util.ArrayList;

public class BruteForce {
    public BruteForce(){

    }


    public int minimumPairDistance = 6969;
    Node root;
    Node current;



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
            int a = findBrute(text.toUpperCase(), pattern1.pattern.toUpperCase());
            int b = findBrute(text.toUpperCase(), pattern2.pattern.toUpperCase());
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
        int lessfirstPattern_Position = findBrute(text.toUpperCase(), current.pattern.toUpperCase());
        current = current.next;
        while (current!=null){
            int temp = findBrute(text.toUpperCase(), current.pattern.toUpperCase());
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
            if(findBrute(text.toUpperCase(), current.pattern.toUpperCase())!=6969){
                N++;
            }
            current = current.next;
        }
        current = root;
        return N;
    }

    public  int findBrute(String text,String pattern) {
        int n = text.length();
        int m = pattern.length();
        for (int i=0; i <= n - m; i++) { // try every starting index within text
            int k = 0; // k is index into pattern
            while (k < m && text.charAt(i+k) == pattern.charAt(k)) // kth character of pattern matches
                k++;
            if (k == m) // if we reach the end of the pattern,
                return i; // substring text[i..i+m-1] is a match
        }
        return 6969; // search failed
    }
}
