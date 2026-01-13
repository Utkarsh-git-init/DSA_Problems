package Strivers_dsa.SlidingWindowTwoPointer;

public class BinarySubarraysWithSum930 {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int res=0;
        if(goal!=0) {
            int ptr1, ptr2, sum;
            ptr1 = ptr2  = sum = 0;
            int multiplier = 1;
            while (ptr1 < nums.length && nums[ptr1] == 0) {
                ptr1++;
                multiplier++;
            }
            ptr2 = ptr1;
            while (ptr2 < nums.length) {
                sum += nums[ptr2++];
                if (sum == goal) {
                    res += multiplier;
                } else if (sum > goal) {
                    multiplier = 1;
                    ptr1++;
                    sum--;
                    while (ptr1 < nums.length && nums[ptr1] == 0) {
                        ptr1++;
                        multiplier++;
                    }
                    res += multiplier;
                }
            }
        }else{
            int ptr=0;
            while(ptr<nums.length){
                int i=1;
                while(ptr<nums.length&&nums[ptr]==0){
                    res+=i;
                    i++;
                    ptr++;
                }
                ptr++;
            }
        }
        return res;
    }

    static void main() {
        System.out.println(numSubarraysWithSum(new int[]{1,0,0,1,0,0,1,0,0,1},2));
    }
}
