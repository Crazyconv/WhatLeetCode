import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class InsertInterval{
    // if it is linkedlist
    public List<Interval> insertInterval2(List<Interval> intervals, Interval newInterval) {
        if(intervals == null)
            return intervals;
        int location = locateInterval(intervals, newInterval);
        location ++;
        while(location < intervals.size()){
            if(intervals.get(location).start > newInterval.end){
                intervals.add(location, newInterval);
                return intervals;
            } else {
                Interval itv = intervals.remove(location);
                newInterval = merge(itv, newInterval);
            }
        }
            
        intervals.add(newInterval);
        return intervals;
    }

    public int locateInterval(List<Interval> intervals, Interval newInterval){
        if(intervals.size() == 0)
            return -1;
        int start = 0, end = intervals.size()-1;
        while(start < end){
            System.out.println(start + "," + end);
            int mid = (end - start + 1) / 2 + start;
            if(intervals.get(mid).end < newInterval.start){
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        if(intervals.get(start).end >= newInterval.start)
            return -1;
        else
            return start;
    }   


    // if it is arraylist
    public List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
        if(intervals == null)
            return intervals;
        List<Interval> mergedintervals = new ArrayList<Interval>();
        boolean inserted = false;
        for(Interval next: intervals){
            if(inserted)
                mergedintervals.add(next);
            else{
                if(next.end < newInterval.start)
                    mergedintervals.add(next);
                else if(next.start > newInterval.end){
                    mergedintervals.add(newInterval);
                    mergedintervals.add(next);
                    inserted = true;
                } else{
                    newInterval = merge(next, newInterval);
                }
            }
        }
        if(!inserted)
            mergedintervals.add(newInterval);
        return mergedintervals;
    }
    public Interval merge(Interval i1, Interval i2){
        int start = (i1.start <= i2.start)? i1.start : i2.start;
        int end = (i1.end >= i2.end)? i1.end : i2.end;
        return new Interval(start, end);
    }

    public static void main(String[] argvs){
        InsertInterval mi = new InsertInterval();
        // List<Interval> intervals = new ArrayList<Interval>();
        List<Interval> intervals = new LinkedList<Interval>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));
        Interval newInterval = new Interval(4, 9);
        intervals = mi.insertInterval2(intervals, newInterval);
        for(Interval i: intervals){
            System.out.print("[" + i.start + "," + i.end + "] ");
        }
        System.out.println();
    }

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