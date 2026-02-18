package Strivers_dsa.Heap.MergeKSortedLists23;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer>  list = new ArrayList<>();
        for(ListNode node:lists){
            ListNode cur = node;
            while(cur!=null){
                list.add(cur.val);
                cur = cur.next;
            }
        }
        int n=list.size();
        if(n==0)
            return null;
        for(int i=(n/2)-1;i>=0;i--){
            heapify(list,i);
        }
        ListNode head =new ListNode(extractMin(list));
        ListNode cur=head;
        while(!list.isEmpty()) {
            cur.next=new ListNode(extractMin(list));
            cur=cur.next;
        }
        return  head;
    }
    void heapify(ArrayList<Integer> list,int i){
        int lc=2*i+1;
        int rc=2*i+2;
        int smallest=i;
        if(lc<list.size()&&list.get(lc)<list.get(smallest))
            smallest=lc;
        if(rc< list.size()&&list.get(rc)<list.get(smallest))
            smallest=rc;
        if(smallest!=i) {
            Collections.swap(list, smallest, i);
            heapify(list, smallest);
        }
    }
    int extractMin(ArrayList<Integer> list){
        int temp=list.getFirst();
        list.set(0,list.getLast());
        list.removeLast();
        heapify(list,0);
        return temp;
    }
    static void main() {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        Solution s = new Solution();
        ListNode head=s.mergeKLists(lists);
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
}
