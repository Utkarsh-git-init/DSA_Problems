package Strivers_dsa.BinaryTrees.DiameterOfBinaryTree543;

public class Solution {
    int diameter;
    public int recursion(TreeNode node){
        if(node==null)
            return 0;
        int temp1=recursion(node.left);
        int temp2=recursion(node.right);
        diameter=Math.max(diameter,temp1+temp2);
        return Math.max(temp1+1,temp2+1);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        return diameter;
    }
}
