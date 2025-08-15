package Strivers_dsa.Array;

public class rotate_array_189 {
    public static void reverse(int[] nums,int begin,int end){
        for(;begin<=end;begin++,end--){
            int temp=nums[begin];
            nums[begin]=nums[end];
            nums[end]=temp;
        }
    }
    public static void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public static void main(String[]args){
        int[] nums={1,2,3,4,5,6,7,8,9,10};
        int k=6;
        rotate(nums,k);
        for(int i:nums)
            System.out.print(i+" ");
    }
}


//1st

//int n=nums.length;
//int simple_k=k%n;
//int new_nums[]=new int[n];
//		for(int j=0,i=simple_k;i<n;i++) {
//new_nums[i]=nums[j];
//j++;
//        }
//        for(int j=n-simple_k,i=0;i<simple_k;i++){
//new_nums[i]=nums[j];
//j++;
//        }
//        for(int i=0;i<n;i++) {
//nums[i]=new_nums[i];
//        }


//2nd time limit exceeded for the below code

//int simple_k=k%nums.length;
//for(int i=0;i<simple_k;i++){
//int temp=nums[nums.length-1];
//            for(int j=nums.length-1;j>0;j--){
//nums[j]=nums[j-1];
//        }
//nums[0]=temp;
//        }


// tried to enhance 1st
/*
int n=nums.length;
        int simple_k=k%n;
        int[]temp=new int[n-simple_k];
        for(int i=0;i<n-simple_k;i++)
            temp[i]=nums[i];
        for(int i=0,j=n-simple_k;i<simple_k;i++,j++)
            nums[i]=nums[j];
        for(int i=0,j=simple_k;i<n-simple_k;i++,j++)
            nums[j]=temp[i];
 */


//moves in cycle
// time O(n), in-place
// tricky but best but performs worse than others
/*
int n=nums.length;
        int simple_k=k%n;
        int j = 0;
        int check=j;
        int temp = nums[0];
        int count = 0;
        if(simple_k==0)
            return;
        while (count < n) {
            j += simple_k;
            if (j > n - 1) {
                j-=n;
            }
            int temp2 = nums[j];
            nums[j] = temp;
            temp = temp2;
            if(j==check){
                j+=1;
                check=j;
                temp=nums[j];
            }
            count++;
        }
 */