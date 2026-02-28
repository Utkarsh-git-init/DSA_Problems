package Strivers_dsa.Heap;

import java.util.HashMap;

public class TopKFrequentElements347 {
    void Heapify(int[] nums, int i,HashMap<Integer,Integer> map){
        int l=2* i +1;
        int r=2* i +2;
        int smallest= i;
        if(l<nums.length&& map.get(nums[l])<map.get(nums[smallest]))
            smallest=l;
        if(r<nums.length&& map.get(nums[r])<map.get(nums[smallest]))
            smallest=r;
        if(smallest!=i){
            int temp=nums[i];
            nums[i]=nums[smallest];
            nums[smallest]=temp;
            Heapify(nums,smallest,map);
        }

    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] res=new int[k];
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        int itr=0;
        System.out.println(map);
        for(int i: map.keySet()){
            if(itr==k+1){
                if(map.get(i)>map.get(res[0])){
                    res[0]=i;
                    Heapify(res,0,map);
                }
            }else{
                if(itr<k)
                    res[itr++]=i;
                if(itr==k){
                    for(int j=(k/2);j>=0;j--){
                        Heapify(res,j,map);
                    }
                    itr++; // this is done so this code doesn't run again
                }
            }
        }
        return res;
    }

    static void main() {
        int[] nums={1,2,1,2,1,2,3,1,3,2};
        int k=2;
        TopKFrequentElements347 obj=new TopKFrequentElements347();
        obj.topKFrequent(nums,k);
    }
}
/*
//same complexity
public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.comparingInt(map::get));

        for(int i: map.keySet()){
            if(pq.size()<k){
                pq.add(i);
            }else{
                if(map.get(i)>map.get(pq.peek())){
                    pq.poll();
                    pq.add(i);
                }
            }
        }
        int[] res=new int[pq.size()];
        int i=0;
        for(int j:pq)
            res[i++]=j;
        return res;
    }
 */