public class CloneGraph{
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        HashMap<Integer, UndirectedGraphNode> m = new HashMap<Integer, UndirectedGraphNode>();
        return cloneGraph(node, m);
    }
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> m){
        UndirectedGraphNode result = m.get(node.label);
        if(result == null){
            result = new UndirectedGraphNode(node.label);
            m.put(node.label, result);
            for(UndirectedGraphNode child : node.neighbors){
                result.neighbors.add(cloneGraph(child, m));
            }
        }
        return result;
    }    
}
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};