public class GroupAnagrams{
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        if(strs.length > 0){
            HashMap<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
            for(int i = 0; i < strs.length; i++){
                String key = sort(strs[i]);
                ArrayList<String> value = m.get(key);
                if(value == null){
                    value = new ArrayList<String>();
                    value.add(strs[i]);
                    m.put(key, value);
                } else {
                    value.add(strs[i]);
                }
            }
            for(ArrayList<String> a : m.values()){
                Collections.sort(a);
                result.add(a);
            }
        }
        return result;
    }

    // since chars in s are only from 'a' to 'z';
    public String sort(String s){
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        char[] result = new char[chars.length];
        for(char c : chars){
            count[(int)c - 'a'] ++;
        }
        for(int i = 1; i < 26; i++){
            count[i] += count[i - 1];
        }
        for(char c : chars){
            result[--count[(int)c - 'a']] = c;
        }
        return new String(result);
    }
}