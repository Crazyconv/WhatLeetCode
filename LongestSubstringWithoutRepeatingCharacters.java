// 基本思路是维护一个窗口
// 每次关注窗口中的字符串，在每次判断中，左窗口和右窗口选择其一向前移动, 同样是维护一个HashSet
// 正常情况下移动右窗口，如果没有出现重复则继续移动右窗口
// 如果发现重复字符，则说明当前窗口中的串已经不满足要求，继续移动有窗口不可能得到更好的结果，此时移动左窗口
// 直到不再有重复字符为止
// 中间跳过的这些串中不会有更好的结果，因为他们不是重复就是更短。
// 因为左窗口和右窗口都只向前，所以两个窗口都对每个元素访问不超过一遍，因此时间复杂度为O(2*n)=O(n),是线性算法。
// 空间复杂度为HashSet的size,也是O(n).

// 一直移动右窗口直到条件满足
// update结果（可能需要再检查条件）
// 移动左窗口直到条件不满足
// 根据实际情况，移动条件可能不同:
// 有的要exact count: 
//    LongestSubstringWithoutRepeatingCharacters
//    LongestSubstringContaining2UniqueCharacters
//    SubstringwithConcatenationofAllWords
// 有的需要范围：
//    MinimumWindowSubstring
public class LongestSubstringWithoutRepeatingCharacters{
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, maxLen = 0;
        HashSet<Character> h = new HashSet<Character>();
        while(j < s.length()){
            // move right pointer until the next character causes duplicates
            while(j < s.length() && !h.contains(s.charAt(j))){
                h.add(s.charAt(j));
                j++;
            }
            int len = j - i;
            if(maxLen < len)
                maxLen = len;
            if(j < s.length()){
                // move left pointer until the duplicate is removed
                while(s.charAt(i) != s.charAt(j)){
                    h.remove(s.charAt(i));
                    i++;
                }
                h.remove(s.charAt(i));
                i++;
            }
        }
        return maxLen;
    }       
}