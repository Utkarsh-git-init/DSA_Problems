package Strivers_dsa.BinarySearchTrees.MaximumSumBSTInBinaryTree1373;

public class Solution {
    boolean flag=true;
    int prev;
    int sum=0;
    int maxSum=Integer.MIN_VALUE;
    void fun(TreeNode node){
        if(node==null)
            return;
        fun(node.left);
        if(flag){
            prev=node.val;
            sum+=node.val;
            flag=false;
        }else{
            if(prev<node.val) {
                prev = node.val;
                sum+=node.val;
            }else{
                sum-=prev;
                maxSum=Math.max(maxSum,sum);
                prev=node.val;
                sum=node.val;
                flag=true;
            }
        }
        fun(node.right);
    }
    public int maxSumBST(TreeNode root) {
        fun(root);
        return Math.max(maxSum, 0);
    }
}
