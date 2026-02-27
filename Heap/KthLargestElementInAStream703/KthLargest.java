package Strivers_dsa.Heap.KthLargestElementInAStream703;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>();
        this.k=k;
        Arrays.sort(nums);
        int i;
        if(k==nums.length+1)
            i=0;
        else
            i=nums.length-k;
        for(;i<nums.length;i++)
            pq.add(nums[i]);
    }

    public int add(int val) {
        if(pq.size()<k){
            pq.add(val);
            return pq.peek();
        }
        if(pq.peek()<val){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}
