package Strivers_dsa.BinaryTrees.BinaryTreeInorderTraversel94;

import java.util.ArrayList;
import java.util.List;

class Solution {
    void traversal(List<Integer> list,TreeNode node){
        if(node==null)
            return;
        traversal(list,node.left);
        list.add(node.val);
        traversal(list,node.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        traversal(list,root);
        return list;
    }
}