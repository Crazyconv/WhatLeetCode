public class WAP{
    public static void main(String[] argvs){
        WAP w = new WAP();
        System.out.println(w.convert("21+43*5-13"));
    }
    public String convert(String s){
        if(s == null || s.length() == 0)
            return "";
        else{
            TreeNode t = convert(s, 0, s.length() - 1);
            StringBuilder sb = new StringBuilder();
            traversal(t, sb);
            return sb.toString();
        }
    }
    public TreeNode convert(String s, int start, int end){
        int root = search(s, start, end);
        if(root == -1)
            return new TreeNode(s.substring(start, end+1));
        else{
            TreeNode t = new TreeNode(s.substring(root, root+1));
            t.left = convert(s, start, root - 1);
            t.right = convert(s, root + 1, end);
            return t;
        }
    }
    public int search(String s, int start, int end){
        int mulDivide = -1;
        for(int i = end; i >= start; i--){
            if(s.charAt(i) == '+' || s.charAt(i) == '-')
                return i;
            else if(mulDivide == -1 && (s.charAt(i) == '*' || s.charAt(i) == '/'))
                mulDivide = i;
        }
        return mulDivide;
    }
    public void traversal(TreeNode t, StringBuilder sb){
        if(t == null)
            return;
        else{
            traversal(t.left, sb);
            traversal(t.right, sb);
            sb.append(t.val);
        }
    }
}

class TreeNode{
    String val;
    TreeNode left;
    TreeNode right;
    public TreeNode(String val){ this.val = val;}
}