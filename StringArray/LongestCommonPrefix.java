public class LongestCommonPrefix{
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];

        for(int index = 0; index < strs[0].length(); index ++){
            char cur = strs[0].charAt(index);
            for(int i = 1; i < strs.length; i++){
                if(index >= strs[i].length() || strs[i].charAt(index) != cur){
                    return strs[0].substring(0, index);
                }
            }
        }
        return strs[0];
    }    
}