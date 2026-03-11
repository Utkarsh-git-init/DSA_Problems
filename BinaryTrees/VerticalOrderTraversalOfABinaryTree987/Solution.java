package Strivers_dsa.BinaryTrees.VerticalOrderTraversalOfABinaryTree987;

import java.util.*;

public class Solution {
    HashMap<TreeNode,int[]> map=new HashMap<>();
    int minCol;
    int maxCol;
    void recursion(TreeNode node,int row,int col){
        if(node==null)
            return;
        map.put(node,new int[]{row,col});
        minCol=Math.min(col,minCol);
        maxCol=Math.max(col,maxCol);
        recursion(node.left,row+1,col-1);
        recursion(node.right,row+1,col+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<TreeNode>> preAns =new ArrayList<>();
        recursion(root,0,0);
        int totalCol=maxCol-minCol+1;
        for(int i=0;i<totalCol;i++)
            preAns.add(new ArrayList<>());
        for(TreeNode node:map.keySet())
            preAns.get(map.get(node)[1]-minCol).add(node);
        Comparator<TreeNode> compare=(a,b)->{
            if(map.get(a)[0]==map.get(b)[0]){
                return a.val-b.val;
            }else{
                return map.get(a)[0]-map.get(b)[0];
            }
        };
        for(List<TreeNode> i: preAns)
            i.sort(compare);
        List<List<Integer>> ans=new ArrayList<>();
        for(List<TreeNode> i:preAns){
            ans.add(new ArrayList<>());
            for(TreeNode j:i){
                ans.getLast().add(j.val);
            }
        }
        return ans;
    }
}
