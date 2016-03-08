public class CourseSchedule{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0)
            return true;

        int[] status = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> neighs = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < numCourses; i++){
            neighs.put(i, new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            ArrayList al = neighs.get(prerequisites[i][0]);
            al.add(prerequisites[i][1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(status[i] == 0){
                if(!DFS(i, neighs, status))
                    return false;
            }
        }
        return true;
    }  
    public boolean DFS(int node, HashMap<Integer, ArrayList<Integer>> neighs, int[] status){
        status[node] = -1;
        for(Integer i: neighs.get(node)){
            if(status[i] == -1)
                return false;
            if(status[i] == 0 && !DFS(i, neighs, status))
                return false;
        }
        status[node] = 1;
        return true;
    }  
}