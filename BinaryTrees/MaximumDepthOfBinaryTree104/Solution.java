package Strivers_dsa.BinaryTrees.MaximumDepthOfBinaryTree104;

class Solution {
    public int recursion(TreeNode node){
        if(node==null)
            return 0;
        int temp1=recursion(node.left);
        int temp2=recursion(node.right);
        return Math.max(temp1+1,temp2+1);
    }
    public int maxDepth(TreeNode root) {
        return recursion(root);
    }
}