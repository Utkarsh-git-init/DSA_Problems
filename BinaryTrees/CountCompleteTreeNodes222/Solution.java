package Strivers_dsa.BinaryTrees.CountCompleteTreeNodes222;

public class Solution {
    int leftHeight(TreeNode node){
        return node==null?0:1+leftHeight(node.left);
    }
    int rightHeight(TreeNode node){
        return node==null?0:1+rightHeight(node.right);
    }
    int traversal(TreeNode node){
        if(node==null){
            return 0;
        }else{
            int rHeight=rightHeight(node);
            int lHeight=leftHeight(node);
            if(rHeight==lHeight){
                return Math.powExact(2,lHeight)-1;
            }else{
                return traversal(node.left)+traversal(node.right)+1;
            }
        }
    }
    public int countNodes(TreeNode root) {
        return traversal(root);
    }
}

/*
public class Solution {
    int count;
    int finalRow=-1;
    boolean check=false;
    void recursion(TreeNode node, int row){
        if(node==null){
            count++;
            finalRow=row;
        }else{
            if(row==finalRow)
                check=true;
            if(check)
                return;
            recursion(node.right,row+1);
            recursion(node.left,row+1);
        }
    }
    public int countNodes(TreeNode root) {
        recursion(root,0);
        return Math.powExact(2,finalRow+1)-1-count;
    }
}
 */