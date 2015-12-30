public class PopulatingNextRightPointersII{
    public void connect(TreeLinkNode root) {
        if(root != null){
            TreeLinkNode cur = root;
            while(true){
                TreeLinkNode first = null, pre = null;
                while(cur != null){
                    if(cur.left != null){
                        if(first == null){
                            first = cur.left;
                            pre = cur.left;
                        } else {
                            pre.next = cur.left;
                            pre = cur.left;
                        }
                    }
                    if(cur.right != null){
                        if(first == null){
                            first = cur.right;
                            pre = cur.right;
                        } else {
                            pre.next = cur.right;
                            pre = cur.right;
                        }
                    }
                    cur = cur.next;
                }
                if(first == null)
                    break;
                else{
                    pre.next = null;
                    cur = first;
                }
            }
        }
    }    
}
public class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}