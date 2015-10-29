import java.util.Map;
import java.util.HashMap;

public class IsomorphicString{
	public static boolean checkWith2Maps(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		if(s1.length() == 0)
			return true;
		Map<Character, Character> m1 = new HashMap<Character, Character>();
		Map<Character, Character> m2 = new HashMap<Character, Character>();
		char c1, c2;

		for(int i = 0; i < s1.length(); i++){
			c1 = s1.charAt(i);
			c2 = s2.charAt(i);
			if(m1.get(c1) != null){
				if(m1.get(c1) != c2)
					return false;
			} else if(m2.get(c2) != null){
				return false;
			} else {
				m1.put(c1, c2);
				m2.put(c2, c1);
			}
		}
		return true;
	}

	public static boolean checkWith1Map(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		if(s1.length() == 0)
			return true;
		Map<Character, Character> m = new HashMap<Character, Character>();
		char c1, c2;

		for(int i = 0; i < s1.length(); i++){
			c1 = s1.charAt(i);
			c2 = s2.charAt(i);
			if(m.get(c1) != null){
				if(m.get(c1) != c2)
					return false;
			} else if(m.containsValue(c2)){
				return false;
			} else {
				m.put(c1, c2);
			}
		}
		return true;
	}
	public static void main(String[] argvs){
		System.out.println(checkWith1Map("bar", "foo"));
		System.out.println(checkWith2Maps("bar", "foo"));
		System.out.println(checkWith1Map("foo", "bar"));
		System.out.println(checkWith2Maps("foo", "bar"));
		System.out.println(checkWith2Maps("abc", "def"));
		System.out.println(checkWith1Map("abc", "def"));
	}
}