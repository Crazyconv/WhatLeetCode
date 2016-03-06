public class PascalsTriangleII{
    public List<Integer> getRow(int rowIndex) {
        Integer[] result = new Integer[rowIndex + 1];
        Arrays.fill(result, 0);
        result[0] = 1;
        for(int row = 1; row <= rowIndex; row++){
            for(int j = row; j >= 1; j --){
                result[j] += result[j-1];
            }
        }
        return Arrays.asList(result);
    }  
}