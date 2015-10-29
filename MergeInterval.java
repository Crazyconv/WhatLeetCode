import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class MergeInterval{
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1)
            return intervals;
        List<Interval> mergedintervals = new ArrayList<Interval>();
        Collections.sort(intervals, IntervalComparator);
        Interval prev = null;
        for(Interval next: intervals){
            if(prev == null){
                prev = next;
            } else {
                if(prev.end >= next.start){
                    int newEnd = (prev.end > next.end)? prev.end: next.end;
                    prev = new Interval(prev.start, newEnd);
                } else {
                    mergedintervals.add(prev);
                    prev = next;
                }
            }
        }
        mergedintervals.add(prev);
        return mergedintervals;
    }

    public static void main(String[] argvs){
        MergeInterval mi = new MergeInterval();
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(15, 18));
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals = mi.merge(intervals);
        for(Interval i: intervals){
            System.out.print("[" + i.start + "," + i.end + "] ");
        }
        System.out.println();
    }

    static Comparator<Interval> IntervalComparator = new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2){
            return i1.start - i2.start;
        }
    };

    static class Interval {
        int start;
        int end;
        Interval(){
            start = 0; end = 0; 
        }
        Interval(int s, int e) { 
            start = s; end = e; 
        }
    }
}