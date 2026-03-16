package Strivers_dsa.BinaryTrees.SymmetricTree101;

public class Solution {
    boolean res=true;
    void recursion(TreeNode node1,TreeNode node2){
        if(node1==null||node2==null){
            if(!(node1==null&&node2==null)){
                res=false;
            }
            return;
        }
        if(node1.val!=node2.val) {
            res = false;
            return;
        }
        recursion(node1.left,node2.right);
        recursion(node1.right,node2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        recursion(root,root);
        return res;
    }
}
