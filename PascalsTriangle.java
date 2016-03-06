public class PascalsTriangle{
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows > 0){
            ArrayList<Integer> pre = new ArrayList<Integer>();
            pre.add(1);
            result.add(pre);
            for(int i = 2; i <= numRows; i++){
                ArrayList<Integer> cur = new ArrayList<Integer>();
                cur.add(1);
                for(int j = 1; j < pre.size(); j++){
                    cur.add(pre.get(j-1) + pre.get(j));
                }
                cur.add(1);
                result.add(cur);
                pre = cur;
            }
        }
        return result;
    }    
}