package Strivers_dsa;
import java.util.*;
public class majority_element_II_229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> hmap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hmap.put(nums[i],hmap.getOrDefault(nums[i],0)+1);
        }
        for(int i: hmap.keySet()){
            if(hmap.get(i)>nums.length/3)
                ans.add(i);
        }
        return ans;
    }
}
