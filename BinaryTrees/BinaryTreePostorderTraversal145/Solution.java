package Strivers_dsa.BinaryTrees.BinaryTreePostorderTraversal145;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        HashSet<TreeNode> set=new HashSet<>();
        stack.push(root);
        set.add(null);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node==null)
                continue;
            if(set.contains(node.left)&&set.contains(node.right)){
                list.add(node.val);
                set.add(node);
            }else{
                stack.push(node);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return list;
    }
}

/*
public class Solution {
    void traversal(List<Integer> list,TreeNode node){
        if(node==null)
            return;
        traversal(list,node.left);
        traversal(list,node.right);
        list.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        traversal(list,root);
        return list;
    }
}
 */