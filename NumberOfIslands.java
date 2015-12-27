import java.util.HashSet;
public class NumberOfIslands{
    public int numIslands(char[][] grid) {
        if(grid != null && grid.length != 0 && grid[0].length != 0){
            int rowNum = grid.length;
            int colNum = grid[0].length;
            int p[] = new int[rowNum * colNum];
            for(int i = 0; i < rowNum; i++){
                for(int j = 0; j < colNum; j++){
                    if(grid[i][j] == '0')
                        p[i * colNum + j] = -1;
                    else
                        p[i * colNum + j] = i * colNum + j;
                }
            }
            for(int i = 0; i < rowNum; i++){
                for(int j = 0; j < colNum; j++){
                    if(grid[i][j] == '1'){
                        int y = find(i * colNum + j, p);
                        if(j+1 < colNum && grid[i][j+1] == '1'){
                            int x = find(i * colNum + j + 1, p);
                            if(x != y)
                                p[x] = y;
                        }
                        if(i+1 < rowNum && grid[i+1][j] == '1'){
                            int x = find((i + 1) * colNum + j, p);
                            if(x != y)
                                p[x] = y;
                        }
                    }
                }
            }
            // for(int i = 0; i < rowNum; i++){
            //     for(int j = 0; j < colNum; j++){
            //         System.out.printf("%4d",p[i * colNum + j]);
            //     }
            //     System.out.println();
            // }


            int count = 0;
            HashSet<Integer> islands = new HashSet<Integer>();
            for(int i = 0; i < rowNum * colNum; i++){
                if(p[i] != -1){
                    p[i] = find(i, p);
                    if(!islands.contains(p[i])){
                        islands.add(p[i]);
                        count ++;
                    }
                }
            }
            // for(int i = 0; i < rowNum; i++){
            //     for(int j = 0; j < colNum; j++){
            //         System.out.printf("%4d",p[i * colNum + j]);
            //     }
            //     System.out.println();
            // }
            return count;
        }
        return 0;
    }
    public int find(int x, int[] p){
        return (p[x] == x)? x:(p[x] = find(p[x], p));
    }
    public static void main(String[] argvs){
        NumberOfIslands noi = new NumberOfIslands();
        //String[] nums = {"01001110000010000101","10100110010101011000","01000111100000111101","11000110001110010110","01011010001001000001","10010100011010010000","10001100000100100001","10001011101011110001","10010001000000000101","00010111111111000010","10101001110110011000","01001000000111100010","10001110100010101001","00001011010101111000","01100001001110011010","10111111011010010001","10001010010100100111","00100001001101110000","00100000011010100011","10001011100101011000"};
        String[] nums = {"1"};
        char[][] chars = new char[nums.length][nums[0].length()];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[0].length(); j++){
                chars[i][j] = nums[i].charAt(j);
            }
        }
        System.out.println(noi.numIslands(chars));
    }    
}