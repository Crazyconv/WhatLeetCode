import java.util.HashMap;
public class TwoSumDS{
    private Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
    public void add(int number){
        if(hm.containsKey(number)){
            hm.put(number, hm.get(number)+1);
        } else {
            hm.put(number, 1);
        }
    }
    public boolean find(int value){
        for(int key: hm.keySet()){
            int target = value - key;
            if(hm.containsKey(target)){
                if(target != key || hm.get(target) > 1)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] argvs){
        TwoSumDS ts = new TwoSumDS();
        ts.add(0);
        ts.add(-1);
        ts.add(1);
        System.out.println(ts.find(0));
    }
}