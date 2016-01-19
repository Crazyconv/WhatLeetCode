public class MaximumProductofWordLengths{
    // use bit operation is much faster than bitset (151ms)...
    // prune... 45ms
    // unfortunately, sorting + prune is slower 25 ms
    public int maxProduct(String[] words) {
        if(words == null || words.length < 2)
            return 0;

        Arrays.sort(words, new Comparator<String>(){
            public int compare(String s1, String s2){
                int len1 = s1.length();
                int len2 = s2.length();
                if(len1 < len2)
                    return -1;
                else if(len1 > len2)
                    return 1;
                else
                    return 0;
            }
        });

        int[] bs = new int[words.length];
        int[] len = new int[words.length];
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                bs[i] |= (1 << ((int) words[i].charAt(j) - 'a'));
            }
            len[i] = words[i].length();
        }

        int max = 0;
        for(int i = words.length - 1; i > 0; i--){
            if(len[i] * len[i] <= max) break;
            for(int j = i - 1; j >= 0; j --){
                int product = len[i] * len[j];
                if(product <= max) break;
                if((bs[i] & bs[j]) == 0){
                    max = product;
                    break;
                }
            }
        }
        return max;
    }

    // 76 ms
    public int maxProduct(String[] words) {
        if(words == null || words.length < 2)
            return 0;

        HashSet<Integer, Integer> m = new HashSet<Integer, Integer>();
        for(int i = 0; i < words.length; i++){
            int mask = 0;
            int len = words[i].length();
            for(int j = 0; j < words[i].length(); j++){
                mask |= (1 << ((int) words[i].charAt(j) - 'a'));
            }
            if(m.get(mask) == null || m.get(mask) < len)
                m.put(mask, len);
        }

        int max = 0;
        for(Integer key1 : m.keySet()){
            int len1 = m.get(key1);
            for(Integer key2 : m.keySet()){
                if(key1 & key2 == 0){
                    int len = len1 * m.get(key2);
                    // if(max < len)
                    //     max = len;

                    // the following two is faster than the above
                    max = Math.math(max, len);
                    // max = (max > len)? max : len;
                }
            }
        }
        return max;
    }   
}