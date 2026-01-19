package Strivers_dsa.SlidingWindowTwoPointer
//
//class Solution {
//    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
//        var ptr1=0
//        var ptr2=0
//        var multiplier=1
//        while(ptr1<nums.size&&nums[ptr1]%2==0){
//            ptr1++;
//        }
//        ptr2=ptr1
//        multiplier=ptr1+1
//        var res=0
//        var noOfOdds=0
//        while(ptr2 < nums.size&&noOfOdds!=k){
//            if(nums[ptr2]%2!=0)
//                noOfOdds++;
//            ptr2++;
//        }
//        if(noOfOdds==k)
//            res+=multiplier
//        while (ptr2 < nums.size){
//            if(nums[ptr2]%2!=0){
//                ptr1++
//                multiplier=1
//                while(nums[ptr1]%2==0){
//                    ptr1++
//                    multiplier++
//                }
//            }
//            res+=multiplier
//            ptr2++
//        }
//        return  res
//    }
//}
class Solution {
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        var map=mutableMapOf<Int, Int>()
        var noOfOdds=0
        var res=0
        map[0]=1
        for(itr in nums){
            if(itr%2!=0)
                noOfOdds++
            map[noOfOdds] = map.getOrDefault(noOfOdds,0)+1
            res+=map.getOrDefault(noOfOdds-k,0)
        }
        return res;
    }
}
fun main(){
    var nums=intArrayOf(2,2,2,1,2,2,1,2,2,2)
    var obj=Solution()
    obj.numberOfSubarrays(nums,2)
}