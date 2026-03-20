package Strivers_dsa.BinaryTrees.ConstructBinaryTreefromPreorderAndInorderTraversal105;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        TreeNode root=new TreeNode(preorder[0]);
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        for(int i=1;i<preorder.length;i++){
            TreeNode node=new TreeNode(preorder[i]);
            if(!stack.isEmpty()&&map.get(preorder[i])<map.get(stack.peek().val)){
                stack.peek().left=node;
                stack.push(node);
            }else{
                TreeNode temp=null;
                while(!stack.isEmpty()&&map.get(preorder[i])>map.get(stack.peek().val))
                    temp=stack.pop();
                assert temp != null;
                temp.right=node;
                stack.push(node);
            }
        }
        return root;
    }
}
