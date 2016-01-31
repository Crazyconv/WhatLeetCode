import java.util.*;
public class SerializeAndDeserializeBinaryTree{
    /* ==========================================================
     * +                          BFS                           =
     * =========================================================*/
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return null;
        else{
            ArrayList<String> result = new ArrayList<String>();
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            result.add(String.valueOf(root.val));
            q.offer(root);
            while(!q.isEmpty()){
                TreeNode node = q.poll();
                if(node.left != null){
                    result.add(String.valueOf(node.left.val));
                    q.offer(node.left);
                } else {
                    result.add(" ");
                }
                if(node.right != null){
                    result.add(String.valueOf(node.right.val));
                    q.offer(node.right);
                } else {
                    result.add(" ");
                }
            }
            return String.join(",", result);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null)
            return null;
        else{
            String[] result = data.split(",");
            TreeNode root = new TreeNode(Integer.valueOf(result[0]));
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.offer(root);
            int index = 1;
            while(!q.isEmpty()){
                TreeNode node = q.poll();
                if(!result[index].equals(" ")){
                    node.left = new TreeNode(Integer.valueOf(result[index]));
                    q.offer(node.left);
                }
                if(!result[index+1].equals(" ")){
                    node.right = new TreeNode(Integer.valueOf(result[index+1]));
                    q.offer(node.right);
                }
                index += 2;
            }
            return root;
        }
    }

    /* ==========================================================
     * +                         pre order                      =
     * =========================================================*/

    // use StringBuilder!!!
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    void buildString(TreeNode node, StringBuilder sb){
        if(node == null)
            sb.append(" ").append(",");
        else{
            sb.append(node.val).append(",");
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        Queue<String> ss = new LinkedList<String>();
        ss.addAll(Arrays.asList(data.split(",")));
        return buildTree(ss);
    }

    TreeNode buildTree(Queue<String> ss){
        String s = ss.poll();
        if(s.equals(" "))
            return null;
        else{
            TreeNode t = new TreeNode(Integer.valueOf(s));
            t.left = buildTree(ss);
            t.right = buildTree(ss);
            return t;
        }
    }

    public static void main(String[] argvs){
        SerializeAndDeserializeBinaryTree sadb = new SerializeAndDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        String s = sadb.serialize(root);
        root = sadb.deserialize(s);
        s = sadb.serialize(root);
        System.out.println(s);
    }   
}

class TreeNode{
    int val;
    TreeNode left; 
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}