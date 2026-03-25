package Strivers_dsa.BinarySearchTrees.KthSmallestInBST230;

public class Solution {
    int count=0;
    int res=-1;
    boolean found=false;
    void recursion(TreeNode node,int k){
        if(node==null||found)
            return;
        recursion(node.left,k);
        count++;
        if(count==k){
            res=node.val;
            found=true;
        }
        recursion(node.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        recursion(root,k);
        return res;
  }
}
