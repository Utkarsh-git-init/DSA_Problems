package Strivers_dsa.BinaryTrees.MaximumWidthOfBinaryTree662;

import java.util.*;

/*
for this solution i am indexing every node in a level in a deque named 'index'
and then same as before remove leading and trailing null values including their indexes
width of the level becomes last index - first index +1
*/


public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> deque=new LinkedList<>();
        Deque<Integer> index=new ArrayDeque<>();
        deque.add(root);
        index.add(1);
        int res=1;
        while(!deque.isEmpty()){
            int n=deque.size();
            for(int i=0;i<n;i++){
                TreeNode node=deque.pollFirst();
                int indexVal=index.pollFirst();
                if(node!=null){
                    deque.addLast(node.left);
                    index.addLast(2*(indexVal-1)+1);
                    deque.addLast(node.right);
                    index.addLast(2*(indexVal-1)+2);
                }
            }
            while(!deque.isEmpty()&&deque.peekFirst()==null) {
                deque.pollFirst();
                index.pollFirst();
            }
            while (!deque.isEmpty()&&deque.peekLast()==null) {
                deque.pollLast();
                index.pollLast();
            }
            if(!deque.isEmpty())
                res=Math.max(res,index.peekLast()-index.peekFirst()+1);
        }
        return res;
    }
}

/*

I am storing all the nodes in a level using BFS. if i get null i add null twice in next level.
then remove leading and trailing nodes and the size of deque is your width of level
this answer gave me TLE


public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> deque=new LinkedList<>();
        deque.add(root);
        int res=0;
        while(!deque.isEmpty()){
            int n=deque.size();
            for(int i=0;i<n;i++){
                TreeNode node=deque.pollFirst();
                if(node==null){
                    deque.addLast(null);
                    deque.addLast(null);
                }else{
                    deque.addLast(node.left);
                    deque.addLast(node.right);
                }
            }
            while(!deque.isEmpty()&&deque.peekFirst()==null)
                deque.pollFirst();
            while (!deque.isEmpty()&&deque.peekLast()==null)
                deque.pollLast();
            res=Math.max(res,deque.size());
        }
        return res;
    }
}
 */
