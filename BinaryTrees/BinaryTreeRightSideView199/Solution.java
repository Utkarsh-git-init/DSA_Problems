package Strivers_dsa.BinaryTrees.BinaryTreeRightSideView199;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    //could use arraylist and if rowcount becomes arraylist size which means we got to that row first time we can add the node in list
    HashMap<Integer,TreeNode> rightMost=new HashMap<>();
    void recursion(TreeNode node, int row, int col){
        if(node==null)
            return;
        if(!rightMost.containsKey(row))
            rightMost.put(row,node);
        recursion(node.right,row+1,col-1);
        recursion(node.left,row+1,col+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        recursion(root,0,0);
        for(int i=0;i<rightMost.size();i++){
            res.add(rightMost.get(i).val);
        }
        return res;
    }
}
