public class Candy{
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        for(int i = 1; i < len; i++){
            if(ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
            else
                left[i] = 1;
        }
        right[len - 1] = 1;
        for(int i = len - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
            else
                right[i] = 1;
        }
        int result = 0;
        for(int i = 0; i < len; i++){
            result += Math.max(right[i], left[i]);
        }
        return result;
    }
}