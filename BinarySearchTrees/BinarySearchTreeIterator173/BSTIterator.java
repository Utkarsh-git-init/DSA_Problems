package Strivers_dsa.BinarySearchTrees.BinarySearchTreeIterator173;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack=new Stack<>();
        stack.push(root);
        while(stack.peek()!=null)
            stack.push(stack.peek().left);
        stack.pop();
    }

    public int next() {
        TreeNode node=stack.pop();
        stack.push(node.right);
        while (stack.peek()!=null)
            stack.push(stack.peek().left);
        stack.pop();
        return node.val;
    }

    public boolean hasNext() {
        return stack.isEmpty();
    }
}

/*
sol 1

public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack=new Stack<>();
        stack.push(root);
        while(stack.peek()!=null){
            TreeNode node=stack.pop();
            stack.push(node.right);
            stack.push(node);
            stack.push(node.left);
        }
    }

    public int next() {
        while (!stack.isEmpty()&&stack.peek()!=null){
            TreeNode temp=stack.pop();
            stack.push(temp.right);
            stack.push(temp);
            stack.push(temp.left);
        }
        stack.pop();
        return stack.pop().val;
    }

    public boolean hasNext() {
        if(!stack.isEmpty()){
            if(stack.peek()==null){
                stack.pop();
                if(stack.isEmpty())
                    return false;
                stack.push(null);
                return true;
            }
            return true;
        }
        return false;
    }
}


 */