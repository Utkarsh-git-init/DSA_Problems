package Strivers_dsa.BinaryTrees.SerializeAndDeserializeBinaryTree297;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "";
        StringBuilder data=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        data.append(root.val);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node==null)
                continue;
            queue.add(node.left);
            data.append(node.left == null ? "$Null" : "$"+node.left.val);
            queue.add(node.right);
            data.append(node.right == null ? "$Null" : "$"+node.right.val);
        }
        return data.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        String[] arr=data.split("\\$");
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        for(int i=0,j=1;j<arr.length;i++){
            if(Objects.equals(arr[i],"Null"))
                continue;
            TreeNode node=queue.poll();
            if(!Objects.equals(arr[j],"Null")){
                assert node != null;
                node.left=new TreeNode(Integer.parseInt(arr[j]));
                queue.add(node.left);
            }
            if(!Objects.equals(arr[++j],"Null")){
                assert node != null;
                node.right=new TreeNode(Integer.parseInt(arr[j]));
                queue.add(node.right);
            }
            j++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));