package Strivers_dsa.Linked_list;
//Specifically For question 138. Copy List with Random Pointer
public class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
