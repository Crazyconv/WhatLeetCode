public class MeetingRooms{
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return Integer.compare(i1.start, i2.start);
            }
        });

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i-1].end)
                return false;
        }
        return true;
    }    
}