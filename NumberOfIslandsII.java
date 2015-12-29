import java.util.List;
import java.util.ArrayList;
public class NumberOfIslandsII{
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<Integer>();
        if(m > 0 && n > 0 && positions != null){
            int count = 0;
            int[] p = new int[m*n];
            int[][] neig = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for(int i = 0; i < positions.length; i ++){
                int row = positions[i][0];
                int col = positions[i][1];
                p[row * n + col] = row * n + col + 1;
                count ++;
                for(int j = 0; j < 4; j ++){
                    int neiRow = row + neig[j][0];
                    int neiCol = col + neig[j][1];
                    if(neiRow >= 0 && neiRow < m && neiCol >= 0 && neiCol < n && p[neiRow * n + neiCol] != 0){
                        int x = find(row * n + col, p);
                        int y = find(neiRow * n + neiCol, p);
                        if(x != y){
                            count --;
                            p[x-1] = y;
                        }
                    }
                }
                result.add(count);
            }
        }
        return result;
    }
    public int find(int x, int[] p){
        return (p[x] == x + 1)? p[x]:(p[x] = find(p[x]-1, p));
    }
    public static void main(String[] argvs){
        NumberOfIslandsII noi = new NumberOfIslandsII();
        int m = 3, n = 3;
        int[][] positions = {{0,0},{0,1},{1,2},{2,1}};
        List<Integer> result = noi.numIslands2(m,n,positions);
        for(Integer i: result)
            System.out.println(i);
    }    
}