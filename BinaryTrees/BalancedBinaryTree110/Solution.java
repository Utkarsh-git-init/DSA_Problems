package Strivers_dsa.BinaryTrees.BalancedBinaryTree110;

public class Solution {
    boolean res=true;
    public int recursion(TreeNode node){
        if(node==null)
            return 0;
        int temp1=recursion(node.left);
        int temp2=recursion(node.right);
        if(Math.max(temp1,temp2)-Math.min(temp1,temp2)>1)
            res=false;
        return Math.max(temp1+1,temp2+1);
    }
    public boolean isBalanced(TreeNode root) {
        recursion(root);
        return res;
    }
}
