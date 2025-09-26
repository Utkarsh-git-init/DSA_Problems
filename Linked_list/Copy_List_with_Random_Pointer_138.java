package Strivers_dsa.Linked_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Copy_List_with_Random_Pointer_138 {
    public static Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        HashMap<Node,Integer> orignal=new HashMap<>();
        HashMap<Integer,Node> copy=new HashMap<>();
        Node new_head = new Node(head.val);
        orignal.put(head,0);
        copy.put(0,new_head);
        Node itr1 = head.next;
        Node itr2 = new_head;
        int i=1;
        while(itr1!=null){
            itr2=itr2.next = new Node(itr1.val);
            orignal.put(itr1,i);
            copy.put(i,itr2);
            i++;
            itr1 = itr1.next;
        }
        int size=i;
        itr2.next = null;
        itr1=head;
        itr2 = new_head;
        while(itr1!=null){
            itr2.random=copy.get(orignal.get(itr1.random));
            itr1=itr1.next;
            itr2=itr2.next;
        }
        return new_head;
    }
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes:");
        int n = sc.nextInt();
        if(n==0){
            copyRandomList(null);
            return;
        }
        int []value=new int [n];
        int []rand=new int [n];
        Node []nodes=new Node [n];
        System.out.println("Enter -1 for null");
        for(int i=0;i<n;i++) {
            value[i]=sc.nextInt();
            rand[i]=sc.nextInt();
        }
        Node head = new Node(value[0]);
        nodes[0]=head;
        Node itr=head;
        for(int i=1;i<n;i++) {
            itr.next= new Node(value[i]);
            itr=itr.next;
            nodes[i]=itr;
        }
        itr.next=null;
        itr=head;
        for(int i=0;i<n;i++) {
            if(rand[i]==-1) {
                itr.random=null;
                itr=itr.next;
                continue;
            }
            itr.random=nodes[rand[i]];
            itr=itr.next;
        }
        //itr=head;
        //to check input Linked list by printing nodes
        /*while(itr!=null) {
            System.out.println("node "+itr+" node value "+itr.val+" random "+itr.random);
            itr=itr.next;
        }*/
        //Copied linked list
        Node copy_head=copyRandomList(head);
        Node new_itr=copy_head;
        while(new_itr!=null) {
            System.out.println("node "+new_itr+" node value "+new_itr.val+" random "+new_itr.random);
            new_itr=new_itr.next;
        }
    }
}
//first test case
/*
5
7 -1
13 0
11 4
10 2
1 0
 */