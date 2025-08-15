package Strivers_dsa.Array;
import java.util.*;
public class three_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer,Integer> hmap =new HashMap();
        HashSet<ArrayList<Integer>> tempres=new HashSet<>();
        List<List<Integer>> result=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            hmap.put(nums[i],i);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int rest=-nums[i]-nums[j];
                if(hmap.containsKey(rest)&&j<hmap.get(rest)){
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(rest);
                    Collections.sort(temp);
                    tempres.add(new ArrayList<>(temp));
                    temp.clear();
                }
            }
        }
        result.addAll(tempres);
        return result;
    }
    public static void main(String[]args){

    }
}
// hmap doesnt contain repeated numbers
//-1,0,1,-1,0,1
// same triplet repeats but give only one output
//soln 1 TLE
/*
public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer,Integer> hmap =new HashMap();
        List<List<Integer>> result=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            hmap.put(nums[i],i);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int rest=-nums[i]-nums[j];
                if(hmap.containsKey(rest)&&j<hmap.get(rest)){
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(rest);
                    Collections.sort(temp);
                    boolean exists=false;
                    for(int k=0;k<result.size();k++){
                        exists=temp.equals(result.get(k));
                        if(exists)
                            break;
                    }
                    if(exists){
                        temp.clear();
                        continue;
                    }
                    result.add(new ArrayList<>(temp));
                    temp.clear();
                }
            }
        }
        return result;
    }
 */
// soln 2 beats 6% 1428 ms
/*
public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer,Integer> hmap =new HashMap();
        HashSet<ArrayList<Integer>> tempres=new HashSet<>();
        List<List<Integer>> result=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            hmap.put(nums[i],i);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int rest=-nums[i]-nums[j];
                if(hmap.containsKey(rest)&&j<hmap.get(rest)){
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(rest);
                    Collections.sort(temp);
                    tempres.add(new ArrayList<>(temp));
                    temp.clear();
                }
            }
        }
        result.addAll(tempres);
        return result;
    }
 */