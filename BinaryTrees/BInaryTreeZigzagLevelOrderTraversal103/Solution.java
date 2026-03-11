package Strivers_dsa.BinaryTrees.BInaryTreeZigzagLevelOrderTraversal103;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        List<List<Integer>> listVal=new ArrayList<>();
        List<List<TreeNode>> list=new ArrayList<>();
        list.add(new ArrayList<>(Collections.singletonList(root)));
        listVal.add(new ArrayList<>(List.of(root.val)));
        boolean change=false;
        while (true){
            List<TreeNode> temp1=new ArrayList<>();
            List<Integer> temp2=new ArrayList<>();
            if(change){
                for(int i=list.getLast().size()-1;i>=0;i--){
                    TreeNode node=list.getLast().get(i);
                    if(node.left!=null) {
                        temp1.add(node.left);
                        temp2.add(node.left.val);
                    }
                    if(node.right!=null) {
                        temp1.add(node.right);
                        temp2.add(node.right.val);
                    }
                }
                change=false;
            }else{
                for(int i=list.getLast().size()-1;i>=0;i--){
                    TreeNode node=list.getLast().get(i);
                    if(node.right!=null) {
                        temp1.add(node.right);
                        temp2.add(node.right.val);
                    }
                    if(node.left!=null) {
                        temp1.add(node.left);
                        temp2.add(node.left.val);
                    }
                }
                change=true;
            }
            if(temp1.isEmpty())
                break;
            list.add(temp1);
            listVal.add(temp2);
        }
        return listVal;
    }
}
