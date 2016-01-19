public class NumberofConnectedComponentsUndirectedGraph{
    // union find
    public int countComponents(int n, int[][] edges) {
        int[] p = new int[n];
        for(int i = 0; i < n; i++)
            p[i] = i;
        for(int[] e : edges){
            int x = find(p, e[0]);
            int y = find(p, e[1]);
            if(x != y)
                p[x] = y;
        }
        HashSet<Integer> cc = new HashSet<Integer>();
        for(int i = 0; i < n; i++){
            cc.add(find(p, i));
        }
        return cc.size();
    } 
    public int find(int[] p, int x){
        if(x != p[x])
            return p[x] = find(p, p[x]);
        else
            return x;
    }   

    // BFS  DFS   
}