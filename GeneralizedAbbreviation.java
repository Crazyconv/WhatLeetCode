public class GeneralizedAbbreviation{
    // DFS
    // 14 ms
    public List<String> generateAbbreviations(String word) {
        ArrayList<String> result = new ArrayList<String>();
        if(word != null)
            generate(word, 0, new StringBuilder(), 0, result);
        return result;
    }  
    public void generate(String word, int pos, StringBuilder sb, int count, ArrayList<String> result){
        int len = sb.length();
        if(pos == word.length()){
            if(count > 0)
                sb.append(count);
            result.add(sb.toString());
        } else {
            // abb
            generateA(word, pos + 1, sb, count + 1, result);
            // don't abb
            if(count != 0)
                sb.append(count);
            sb.append(word.charAt(pos));
            generate(word, pos + 1, sb, 0, result);
        }
        sb.setLength(len);
    }

    // DFS 2
    // 15 ms
    public List<String> generateAbbreviations(String word) {
        ArrayList<String> result = new ArrayList<String>();
        if(word != null){
            generate(word, 0, new StringBuilder(), result);
        }
        return result;
    } 

    public void generate(String word, int pos, StringBuilder sb, ArrayList<String> result){
        if(pos >= word.length()){
            result.add(sb.toString());
        } else {
            int len = sb.length();
            for(int i = 0; pos + i <= word.length() ; i++){
                if(i > 0)
                    sb.append(i);
                if(pos + i < word.length())
                    sb.append(word.charAt(pos + i));
                generate(word, pos + i + 1, sb, result);
                sb.setLength(len);
            }
        }
    }    

    // bit manipulation
    // 40 ms
    public List<String> generateAbbreviations(String word) {
        ArrayList<String> result = new ArrayList<String>();
        if(word != null){
            long mask = 1 << (word.length());
            for(long i = 0; i < mask; i ++){
                result.add(generate(word, i));
            }
        }
        return result;
    }     
    public String generate(String word, long mask){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(long i = 0; i < word.length(); i++){
            long bit = (mask >> i) & 1;
            if(bit == 1)
                count ++;
            else{
                if(count > 0){
                    sb.append(count);
                    count = 0;
                }
                sb.append(word.charAt(i));
            }
        }
        if(count > 0)
            sb.append(count);
        return sb.toString();
    }
}