package Strivers_dsa.BinaryTrees.BinaryTreeInorderTraversel94;

import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node==null){
                list.add(stack.pop().val);
            }else{
                stack.push(node.right);
                stack.push(node);
                stack.push(node.left);
            }
        }
        return list;
    }
}

/*
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

 */

/*
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        HashSet<TreeNode> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node==null)
                continue;
            if(node.left==null){
                set.add(node);
                list.add(node.val);
                stack.push(node.right);
            } else if (set.contains(node.left)) {
                set.add(node);
                list.add(node.val);
            }
            else {
                stack.push(node.right);
                stack.push(node);
                stack.push(node.left);
            }
        }
        return list;
    }
}

 */