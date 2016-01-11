import java.util.HashMap;
public class MaxPointsLine{
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0)
            return 0;
        int maxP = 1;
        for(int i = 0; i < points.length; i++){
            HashMap<Double, Integer> slope = new HashMap<Double, Integer>();
            int verticals = 0;
            int duplicates = 1;
            for(int j = i+1; j < points.length; j++){
                if(points[i].x == points[j].x){
                    if(points[i].y == points[j].y){
                        duplicates ++;
                    } else {
                        verticals ++;
                    }
                } else {
                    // -0.0 != 0.0
                    // double in hashMap or hashSet has no problem, not just equality
                    double s = (points[i].y == points[j].y)? 0.0 :(double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
                    Integer in = slope.get(s);
                    if(in == null)
                        slope.put(s, 1);
                    else
                        slope.put(s, in+1);
                }
            }
            for(Integer count : slope.values()){
                if(count + duplicates > maxP)
                    maxP = count + duplicates;
            }
            if(verticals + duplicates > maxP)
                maxP = verticals + duplicates;
        }
        return maxP;
    }  
    public static void main(String[] argvs){
        Point[] ps = new Point[3];
        ps[0] = new Point(2,3);
        ps[1] = new Point(3,3);
        ps[2] = new Point(-5,3);
        MaxPointsLine mpl = new MaxPointsLine();
        System.out.println(String.valueOf(mpl.maxPoints(ps)));
    }  
}
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}