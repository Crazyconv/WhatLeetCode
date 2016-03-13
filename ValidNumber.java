public class ValidNumber{
	public static void main(String[] argvs){
		ValidNumber vn = new ValidNumber();
		System.out.println(vn.isNumber(" 100.0 "));
		System.out.println(vn.isNumber(".32"));
		System.out.println(vn.isNumber("0.334e"));
		System.out.println(vn.isNumber("0000.32.432"));
		System.out.println(vn.isNumber(".243e-21"));
		System.out.println(vn.isNumber("e2"));
        System.out.println(vn.isNumber("."));
	}
    public boolean isNumber(String s) {
    	if(s != null && s.length() > 0){
    		char[] cs = s.trim().toCharArray();
    		int len = cs.length;

    		int pos = check(0, cs, true);
    		if(pos == -1)
    			return false;
    		else if(pos == len)
    			return true;
    		else
    			return check(pos + 1, cs, false) == len;
    	}
    	return false;
    }	

    public int check(int pos, char[] s, boolean e){
    	int len = s.length;
    	if(pos == len)
    		return -1;

        // sign
		if(s[pos] == '+' || s[pos] == '-'){
			if(pos + 1 < len)
                pos++;
            else
                return -1;
		}

    	boolean decimal = e;
        // first digit either a number or a '.' with a following number
        if(s[pos] >= '0' && s[pos] <= '9')
            pos++;
        else if(decimal && s[pos] == '.' && pos + 1 < len && s[pos+1] >= '0' && s[pos+1] <= '9'){
            decimal = false;
            pos += 2;
        } else {
            return -1;
        }

    	while(pos < len){
    		if(s[pos] < '0' || s[pos] > '9'){
    			if(s[pos] == '.' && decimal){
    				pos ++;
    				decimal = false;
    			} else if(s[pos] == 'e' && e){
    				return pos;
    			} else {
    				return -1;
    			}
    		} else 
    		    pos ++;
    	}
    	return pos;
    }
}