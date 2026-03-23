package Strivers_dsa.BinaryTrees.FlattenBinaryTreeToLinkedList114;


public class Solution {
    void swap(TreeNode node){
        if(node==null)
            return;
        TreeNode temp=node.left;
        node.left=node.right;
        node.right=temp;
        swap(node.left);
        swap(node.right);
    }
    TreeNode convert(TreeNode node){
        if(node==null||(node.left==null&&node.right==null))
            return node;
        TreeNode right=convert(node.right);
        TreeNode left=convert(node.left);
        if(left==null)
            return right;
        else if(right==null) {
            node.right = node.left;
            node.left=null;
        }
        else {
            right.right =node.left;
            node.left=null;
        }
        return left;
    }
    public void flatten(TreeNode root) {
        swap(root);
        convert(root);
    }
}
