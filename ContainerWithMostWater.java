// http://www.cnblogs.com/TenosDoIt/p/3812880.html
public class ContainerWithMostWater{
    public int maxArea(int[] height) {
        if(height == null || height.length <= 1)
            return 0;
        int max = 0;
        int start = 0, end = height.length - 1;
        while(start < end){
            int area = Math.min(height[start], height[end]) * (end - start);
            if(area > max)
                max = area;
            if(height[start] < height[end])
                start ++;
            else if(height[start] > height[end])
                end --;
            else{
                end --;
                start ++;
            }
        }
        return max;
    }
    // 构建结构体包含height和height在原数组中的位置
    // struct Node 
    //     { 
    //         int height; 
    //         int index;
    // };
    // 对该结构体数组按照height的值递增排序，假设排序后的数组为vec.
    // 假设f[i] 表示数组vec[i,i+1,…]内所有height按照原来的位置顺序排列好以后的最大水量
    // 那么f[i-1]可以在O（1）时间内计算出来：
    // 因为vec[i-1].height 小于vec[i,i+1,…]内的所有height
    // 所以以vec[i-1].index为边界的容器高度为vec[i-1].height
    // 最大水量只需要分别计算vec[i,i+1,…]内按原始位置排列最前面和最后面的height，取两者的较大值。
    public int maxArea(int[] height) {
        if(height == null || height.length <= 1)
            return 0;

        int n = height.length;

        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++){
            nodes[i] = new Node(height[i], i);
        }
        Arrays.sort(nodes);

        int minIdx = nodes[n - 1].idx, maxIdx = minIdx;
        int[] dp = new int[n];
        dp[n-1] = 0;
        for(int i = n - 2; i >= 0; i--){
            dp[i] = dp[i + 1];
            int ori = nodes[i].idx;
            if(ori < minIdx){
                minIdx = ori;
                dp[i] = Math.max(dp[i], height[ori] * (maxIdx - ori));
            } else if(ori > maxIdx){
                maxIdx = ori;
                dp[i] = Math.max(dp[i], height[ori] * (ori - minIdx));
            }
        }
        return dp[0];
    }    
}

class Node implements Comparable<Node>{
    int height;
    int idx;
    public Node(int height, int idx){
        this.height = height;
        this.idx = idx;
    }
    public int compareTo(Node n){
        if(height > n.height) return 1;
        else if(height < n.height) return -1;
        else return 0;
    }
}