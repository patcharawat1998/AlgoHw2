public class Node {
    Node next;
    String pattern;
    int rule1;
    int rule2;
    int rule3;
    int ID;

    public Node(String pattern){
        this.pattern = pattern;
    }
    public Node(String pattern, int rule1, int rule2, int rule3,int ID){
        this.pattern = pattern;
        this.rule1 = rule1;
        this.rule2 = rule2;
        this.rule3 = rule3;
        this.ID = ID;
    }

}
