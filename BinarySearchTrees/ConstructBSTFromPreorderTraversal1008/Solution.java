package Strivers_dsa.BinarySearchTrees.ConstructBSTFromPreorderTraversal1008;

import java.util.Stack;

public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode root=new TreeNode(preorder[0]);
        stack.push(root);
        for(int i=1;i<preorder.length;i++){
            TreeNode node=new TreeNode(preorder[i]);
            if(preorder[i]<stack.peek().val){
                stack.peek().left=node;
                stack.push(node);
            }else{
                TreeNode temp=null;
                while (!stack.isEmpty()&&stack.peek().val<preorder[i])
                    temp=stack.pop();
                assert temp!=null;
                temp.right=node;
                stack.push(node);
            }
        }
        return root;
    }
}
