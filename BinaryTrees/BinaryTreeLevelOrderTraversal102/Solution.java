package Strivers_dsa.BinaryTrees.BinaryTreeLevelOrderTraversal102;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<TreeNode>> list=new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(root)));
        List<List<Integer>> listVal=new ArrayList<>();
        listVal.add(new ArrayList<>(Arrays.asList(root.val)));
        while(true){
            List<TreeNode> temp=new ArrayList<>();
            List<Integer> temp2=new ArrayList<>();
            for(TreeNode j:list.getLast()){
                if(j.left!=null) {
                    temp.add(j.left);
                    temp2.add(j.left.val);
                }
                if(j.right!=null) {
                    temp.add(j.right);
                    temp2.add(j.right.val);
                }
            }
            if(temp.isEmpty())
                break;
            list.add(temp);
            listVal.add(temp2);
        }
        return listVal;
    }
}
/*
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<TreeNode>> list=new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(root)));
        while(true){
            List<TreeNode> temp=new ArrayList<>();
            for(TreeNode j:list.getLast()){
                if(j.left!=null)
                    temp.add(j.left);
                if(j.right!=null)
                    temp.add(j.right);
            }
            if(temp.isEmpty())
                break;
            list.add(temp);
        }
        List<List<Integer>> listVal=new ArrayList<>();
        for(List<TreeNode> i:list){
            List<Integer> temp=new ArrayList<>();
            for(TreeNode j:i){
                temp.add(j.val);
            }
            listVal.add(temp);
        }
        return listVal;
    }
}
 */