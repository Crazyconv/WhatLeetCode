public class FlipGame{
    public List<String> generatePossibleNextMoves(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if(s != null && s.length() >= 2){
            char pre = s.charAt(0);
            for(int i = 1; i < s.length(); i++){
                char cur = s.charAt(i);
                if(pre == '1' && cur == '1'){
                    result.add(s.substring(0, i-1) + "00" + s.substring(i+1));
                }
                pre = cur;
            }
        }
        return result;
    }    
}