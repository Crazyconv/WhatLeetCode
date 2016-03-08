import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
public class CourseScheduleII{
    int[] order;
    int pos;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] status = new int[numCourses];
        order = new int[numCourses];
        pos = numCourses - 1;

        HashMap<Integer, ArrayList<Integer>> neighs = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < numCourses; i++){
            neighs.put(i, new ArrayList<Integer>());
        }
        if(prerequisites != null && prerequisites.length != 0){
            for(int i = 0; i < prerequisites.length; i++){
                ArrayList al = neighs.get(prerequisites[i][1]);
                al.add(prerequisites[i][0]);
            }
        }

        for(int i = 0; i < numCourses; i++){
            if(status[i] == 0){
                if(!DFS(i, neighs, status))
                    return new int[0];
            }
        }
        return order;
    }
    public boolean DFS(int node, HashMap<Integer, ArrayList<Integer>> neighs, int[] status){
        status[node] = -1;
        System.out.printf("visit %d\n", node);
        for(Integer i: neighs.get(node)){
            if(status[i] == -1)
                return false;
            if(status[i] == 0 && !DFS(i, neighs, status))
                return false;
        }
        status[node] = 1;
        order[pos--] = node;
        System.out.printf("add %d\n", node);
        return true;
    }

    public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int[] preNum = new int[numCourses];
        int pos = 0;

        HashMap<Integer, ArrayList<Integer>> neighs = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < numCourses; i++){
            neighs.put(i, new ArrayList<Integer>());
        }
        if(prerequisites != null && prerequisites.length != 0){
            for(int i = 0; i < prerequisites.length; i++){
                ArrayList al = neighs.get(prerequisites[i][1]);
                al.add(prerequisites[i][0]);
                preNum[prerequisites[i][0]]++;
            }
        }

        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(preNum[i] == 0)
                queue.offer(i);
        }

        while(!queue.isEmpty()){
            int temp = queue.poll();
            order[pos++] = temp;
            for(Integer nei: neighs.get(temp)){
                preNum[nei]--;
                if(preNum[nei] == 0)
                    queue.push(nei);
            }
        }

        if(pos == numCourses)
            return order;
        else
            return new int[0]; 
    }
    public static void main(String[] argvs){
        CourseScheduleII cs = new CourseScheduleII();
        int[][] pre = {{1,0}};
        for(Integer i: cs.findOrderBFS(2, pre)){
            System.out.println(i);
        }
    }      
}