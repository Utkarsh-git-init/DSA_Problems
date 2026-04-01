package Strivers_dsa.BinarySearchTrees.TwoSumIVInputIsABST653;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    boolean res;
    void recursion(TreeNode node1,TreeNode node2,int k){
    }
    public boolean findTarget(TreeNode root, int k) {

        return res;
    }
}

/*

public class Solution {
    HashSet<Integer> set=new HashSet<>();
    void traversal(TreeNode node){
        if(node==null)
            return;
        set.add(node.val);
        traversal(node.left);
        traversal(node.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        traversal(root);
        for(int i:set){
            if(set.contains(k-i))
                return true;
        }
        return false;
    }
}
 */