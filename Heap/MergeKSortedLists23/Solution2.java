package Strivers_dsa.Heap.MergeKSortedLists23;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        for(ListNode node:lists){
            while(node!=null) {
                priorityQueue.add(node.val);
                node=node.next;
            }
        }
        if(priorityQueue.isEmpty())
            return null;
        ListNode head=new ListNode(priorityQueue.poll());
        ListNode cur=head;
        while(!priorityQueue.isEmpty()){
            cur.next=new ListNode(priorityQueue.poll());
            cur=cur.next;
        }
        return head;
    }
}
