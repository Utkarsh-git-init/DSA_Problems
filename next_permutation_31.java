package Strivers_dsa;

public class next_permutation_31 {
    public static void quick(int arr[],int l,int h){
        if(l>=h)
            return;
        int pivot=arr[h];
        int i=l-1,j=l;
        while(j!=h){
            if(arr[j]<pivot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
            j++;
        }
        int temp2=arr[i+1];
        arr[i+1]=arr[h];
        arr[h]=temp2;
        quick(arr,l,i);
        quick(arr,i+2,h);
    }
    public static void nextPermutation(int[] nums) {
        boolean check=true;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                for(int j=n-1;j>=0;j--){
                    if(nums[j]>nums[i]){
                        int temp=nums[i];
                        nums[i]=nums[j];
                        nums[j]=temp;
                        break;
                    }
                }
                quick(nums,i+1,n-1);
                check= false;
                break;
            }
        }
        if(check){
            for(int i=0;i<n/2;i++){
                int temp=nums[i];
                nums[i]=nums[n-1-i];
                nums[n-1-i]=temp;
            }
        }
    }
    public static void main(String []args){
        int []nums={5};
        nextPermutation(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
