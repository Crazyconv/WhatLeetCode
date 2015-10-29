import java.util.ArrayList;
public class Test{
    public static void main(String[] argvs){
        ArrayList<ArrayList<Integer>> group = new ArrayList();
        ArrayList<Integer> a = new ArrayList();
        a.add(1);
        group.add(a);
        a.add(2);
        System.out.println(group.get(0).get(1));
    }
}