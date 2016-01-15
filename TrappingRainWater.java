// http://www.cnblogs.com/TenosDoIt/p/3812880.html
public class TrappingRainWater{
    // dp
    public int trap(int[] height) {
        if(height == null || height.length <= 2)
            return 0;
        int n = height.length;
        int[] leftHighest = new int[n];
        int[] rightHightest = new int[n];
        leftHighest[1] = height[0];
        rightHightest[n - 2] = height[n - 1];
        for(int i = 2; i < n - 1; i ++){
            leftHighest[i] = Math.max(leftHighest[i - 1], height[i - 1]);
        }
        for(int i = n - 3; i > 0; i ++){
            rightHightest[i] = Math.max(rightHightest[i + 1], height[i + 1]);
        }

        int rain = 0;
        for(int i = 1; i < n - 1; i++){
            int minHeight = Math.min(leftHighest[i], rightHightest[i]) - height[i];
            if(minHeight > 0)
                rain += minHeight;
        }
        return rain;
    }
    // total area - pillar area
    public int trap(int[] height){
        if(height == null || height.length <= 2)
            return 0;

        int n = height.length;
        int maxHeight = 0;
        int maxId = -1;
        for(int i = 0; i < n; i++){
            if(height[i] > maxHeight){
                maxHeight = height[i];
                maxId = i;
            }
        }

        int totalArea = 0;
        int pillarArea = 0;
        int h = 0;
        for(int i = 0; i < maxId; i++){
            int net = height[i] - h;
            if(net > 0){
                totalArea += net * (maxId - i);
                h = height[i];
            }
            pillarArea += height[i];
        }

        h = 0;
        for(int i = n - 1; i > maxId; i--){
            int net = height[i] - h;
            if(net > 0){
                totalArea += net * (i - maxId);
                h = height[i];
            }
            pillarArea += height[i];
        }

        return totalArea - pillarArea;
    }

    // two pointers: one pass
    public int trap(int[] height){
        if(height == null || height.length <= 2)
            return 0;

        int left = 0, right = height.length - 1;
        int h = 0;
        int totalArea = 0, pillarArea = 0;
        while(left <= right){
            if(height[left] < height[right]){
                int net = height[left] - h;
                if(net > 0){
                    totalArea += net * (right - left + 1);
                    h = height[left];
                }
                pillarArea += height[left];
                left ++;
            } else {
                int net = height[right] - h;
                if(net > 0){
                    totalArea += net * (right - left + 1);
                    h = height[right];
                }
                pillarArea += height[right];
                right --;
            }
        }
        return totalArea - pillarArea;
    }
}