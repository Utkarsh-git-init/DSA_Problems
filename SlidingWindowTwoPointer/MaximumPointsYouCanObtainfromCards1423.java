package Strivers_dsa.SlidingWindowTwoPointer;

public class MaximumPointsYouCanObtainfromCards1423 {
    public static int maxScore(int[] cardPoints, int k) {
        int sum =0,itr1=0,itr2=cardPoints.length-1;
        while(itr1<k)
            sum+=cardPoints[itr1++];
        int res=0;
        res=Math.max(res,sum);
        itr1--;
        while(itr1>=0){
            sum+=cardPoints[itr2--]-cardPoints[itr1--];
            res=Math.max(res,sum);
        }
        return res;
    }

    static void main() {
        int[] arr={1,2,3,4,5,6,1};
        System.out.println(maxScore(arr,3));
    }
}
