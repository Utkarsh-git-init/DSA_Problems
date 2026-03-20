package Strivers_dsa.BinaryTrees.ConstructBinaryTreefromInorderAndPostorderTraversal106;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        Stack<TreeNode> stack=new Stack<>();
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        stack.push(root);
        for(int i=postorder.length-2;i>=0;i--){
            TreeNode node=new TreeNode(postorder[i]);
            if(!stack.isEmpty()&&map.get(postorder[i])>map.get(stack.peek().val)){
                stack.peek().right=node;
                stack.push(node);
            }else{
                TreeNode temp=null;
                while (!stack.isEmpty()&&map.get(postorder[i])<map.get(stack.peek().val))
                    temp=stack.pop();
                assert temp!=null;
                temp.left=node;
                stack.push(node);
            }
        }
        return root;
    }
}
