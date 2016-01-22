public class MinimumHeightTrees{
    // https://leetcode.com/discuss/71763/share-some-thoughts
    // O(n)
    // BFS -> travel from leaves until two meetss
    // 58 ms (maybe set is slow)
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }
        ArrayList<HashSet<Integer>> neis = new ArrayList<HashSet<Integer>>();
        for(int i = 0; i < n; i++){
            neis.add(new HashSet<Integer>());
        }
        for(int i = 0; i < edges.length; i++){
            neis.get(edges[i][0]).add(edges[i][1]);
            neis.get(edges[i][1]).add(edges[i][0]);
        }
        ArrayList<Integer> leaves = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            if(neis.get(i).size() == 1)
                leaves.add(i);
        }

        while(leaves.size() > 2){
            n -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<Integer>();
            for(Integer u : leaves){
                Integer v = neis.get(u).iterator().next();
                neis.get(v).remove(u);
                if(neis.get(v).size() == 1)
                    newLeaves.add(v);
            }
            leaves = newLeaves;
        }
        return leaves;
    } 

    // BFS on one node, find the farthest node
    // BFS on it to find the farest node
    // find the middle node of these two
    // from the first method, we know even if multiple longest paths exists,
    // the middle one/two nodes are the same
    // 43 ms
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> neis = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            neis.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.length; i++){
            neis.get(edges[i][0]).add(edges[i][1]);
            neis.get(edges[i][1]).add(edges[i][0]);
        }

        int[] pre = new int[n];
        for(int i = 0; i < n; i ++) pre[i] = -2;
        int end1 = BFS(0, neis, pre);

        pre = new int[n];
        for(int i = 0; i < n; i ++) pre[i] = -2;
        int end2 = BFS(end1, neis, pre);

        ArrayList<Integer> path = new ArrayList<Integer>();
        while(end2 != -1){
            path.add(end2);
            end2 = pre[end2];
        }

        int length = path.size();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(length % 2 == 1){
            result.add(path.get(length / 2));
        } else {
            result.add(path.get(length / 2 - 1));
            result.add(path.get(length / 2));
        }
        return result;
    }
    public int BFS(int root, ArrayList<ArrayList<Integer>> neis, int[] pre){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(root);
        pre[root] = -1;
        int last = root;
        while(q.size() != 0){
            last = q.poll();
            for(int u : neis.get(last)){
                if(pre[u] == -2){
                    pre[u] = last;
                    q.offer(u);
                }
            }
        }
        return last;
    }

    // https://leetcode.com/discuss/72739/two-o-n-solutions
    // nice dp... 
    int[] height1, height2, dp;
    ArrayList<ArrayList<Integer>> neis;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        neis = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            neis.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < edges.length; i++){
            neis.get(edges[i][0]).add(edges[i][1]);
            neis.get(edges[i][1]).add(edges[i][0]);
        }

        height1 = new int[n];
        height2 = new int[n];
        dp = new int[n];
        dfs(0, -1);
        dfs(0, -1, 0);

        for(int i = 0; i < n; i++){
            min = Math.min(dp[i]);
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            if(dp[i] == min)
                result.add(i);
        }
        return result;
    }

    public void dfs(int root, int parent){
        height1[root] = height2[root] = -1;
        for(int u : neis.get(root)){
            if(u != parent){
                dfs(u, root);
                if(height1[u] + 1 > height1[root]){
                    height2[root] = height1[root];
                    height1[root] = height1[u] + 1;
                } else if (height1[u] + 1 > height2[root]){
                    height2[root] = height1[u] + 1;
                }
            }
        }
        height1[root] = (height1[root] < 0)? 0 : height1[root];
    }
}