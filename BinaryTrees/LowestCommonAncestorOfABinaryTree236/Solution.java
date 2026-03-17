package Strivers_dsa.BinaryTrees.LowestCommonAncestorOfABinaryTree236;

public class Solution {
    TreeNode res;
    boolean check=true;
    int recursion(TreeNode node,TreeNode p,TreeNode q){
        if(node==null||!check)
            return 0;
        int temp1=recursion(node.left,p,q);
        int temp2=recursion(node.right,p,q);
        int count=0;
        if(node.val==p.val||node.val==q.val)
            count=1;
        if(temp1+temp2+count==2&&check){
            res=node;
            check=false;
        }
        return temp1+temp2+count;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recursion(root,p,q);
        return res;
    }
}
