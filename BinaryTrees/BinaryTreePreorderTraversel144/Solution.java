package Strivers_dsa.BinaryTrees.BinaryTreePreorderTraversel144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node==null)
                continue;
            list.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return list;
    }
}

/*

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
 */