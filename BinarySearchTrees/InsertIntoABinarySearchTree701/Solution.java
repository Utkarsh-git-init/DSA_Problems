package Strivers_dsa.BinarySearchTrees.InsertIntoABinarySearchTree701;

public class Solution {
    boolean check=false;
    void recursion(TreeNode node, int val){
        if(check)
            return;
        if(node.val>val){
            if(node.right==null){
                node.right=new TreeNode(val);
                check=true;
                return;
            }
            recursion(node.right,val);
        }else{
            if(node.left==null){
                node.left=new TreeNode(val);
                check=true;
                return;
            }
            recursion(node.left,val);
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
            return new TreeNode(val);
        recursion(root,val);
        return root;
    }
}
