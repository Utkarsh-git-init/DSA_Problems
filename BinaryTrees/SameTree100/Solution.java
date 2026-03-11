package Strivers_dsa.BinaryTrees.SameTree100;

public class Solution {
    boolean res=true;
    public void recursion(TreeNode p, TreeNode q){
        if(p==null||q==null){
            if(!(p==null&&q==null)) {
                res=false;
            }
            return;
        }
        if(q.val!=p.val){
            res=false;
        }else{
            recursion(p.left,q.left);
            recursion(p.right,q.right);
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        recursion(p,q);
        return res;
    }
}
