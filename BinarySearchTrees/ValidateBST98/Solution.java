package Strivers_dsa.BinarySearchTrees.ValidateBST98;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    boolean res=true;
    boolean flag=true;
    int prev;
    void inorder(TreeNode node){
        if(node==null)
            return;
        inorder(node.left);
        if(flag) {
            prev = node.val;
            flag=false;
        }else{
            if(node.val<=prev)
                res=false;
            prev=node.val;
        }
        inorder(node.right);
    }
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return res;
    }
}

/*
using space

public class Solution {
    void inorder(TreeNode node,List<Integer> list){
        if(node==null)
            return;
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1))
                return false;
        }
        return true;
    }
}
 */