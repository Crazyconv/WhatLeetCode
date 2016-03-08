public class PopulatingNextRightPointers{
    public void connect(TreeLinkNode root) {
        if(root != null){
            root.next = null;
            TreeLinkNode cur = root;
            TreeLinkNode first = cur.left;
            while(first != null){
                while(cur != null){
                    cur.left.next = cur.right;
                    cur.right.next = (cur.next == null)? null : cur.next.left;
                    cur = cur.next;
                }
                cur = first;
                first = cur.left;
            }
        }
    }   
}
public class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}