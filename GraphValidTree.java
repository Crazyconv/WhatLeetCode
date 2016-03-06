public class GraphValidTree{
    // no cycle + connected
    // union find
    public boolean validTree(int n, int[][] edges) {
        int[] p = new int[n];
        for(int i = 0; i < n; i ++)
            p[i] = i;
        for(int i = 0; i < edges.length; i++){
            int px = find(edges[i][0], p);
            int py = find(edges[i][1], p);
            if(px == py)
                return false;
            else
                p[px] = py;
        }
        // for(int i = 1; i < n; i++){
        //     if(find(i, p) != find(i - 1, p))
        //         return false;
        // }
        // return true;
        return edges.length == n - 1;
    }    
    public int find(int x, int[] p){
        if(x == p[x])
            return x;
        else
            return p[x] = find(p[x], p);
    }

    // BFS - queue
    public boolean validTree(int n, int[][] edges){
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++){
            graph.add(new HashSet<Integer>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        while(!q.isEmpty()){
            int node = q.poll();
            if(visited[node])
                return false;
            visited[node] = true;
            for(int neis: graph.get(node)){
                graph.get(neis).remove(node);
                q.add(neis);
            }
        }
        for(boolean i: visited){
            if(!i)
                return false;
        }
        return true;
    }

    // DFS - stack
    public boolean validTree(int n, int[][] edges){
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++){
            graph.add(new HashSet<Integer>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> q = new Stack<Integer>();
        q.push(0);
        while(!q.isEmpty()){
            int node = q.pop();
            if(visited[node])
                return false;
            visited[node] = true;
            for(int neis: graph.get(node)){
                graph.get(neis).remove(node);
                q.push(neis);
            }
        }
        for(boolean i: visited){
            if(!i)
                return false;
        }
        return true;
    }
}