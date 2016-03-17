public class OneEditDistance{
    public boolean isOneEditDistance(String s, String t) {
        int status = s.length() - t.length();
        if(status != -1 && status != 0 && status != 1)
            return false;
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i++) != t.charAt(j++)){
                switch(status){
                    case 1 : j--; status = 2; break;
                    case 0 : status = 2; break;
                    case -1 : i--; status = 2; break;
                    default : return false;
                }
            }
        }
        return status != 0;
    }    
}