package Strivers_dsa.BinaryTrees.BinaryTreePreorderTraversel144;

import java.util.ArrayList;
import java.util.List;

class Solution {
    void traversal(List<Integer> list,TreeNode node){
        if(node==null)
            return;
        list.add(node.val);
        traversal(list,node.left);
        traversal(list,node.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        traversal(list,root);
        return list;
    }
}