public class LetterCombinationsofaPhoneNumber{
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0)
            return result;

        HashMap<Character, String> m = new HashMap<Character, String>();
        m.put('2', "abc");
        m.put('3', "def");
        m.put('4', "ghi");
        m.put('5', "jkl");
        m.put('6', "mno");
        m.put('7', "pqrs");
        m.put('8', "tuv");
        m.put('9', "wxyz");

        StringBuilder sb = new StringBuilder();
        combination(digits, 0, m, sb, result);
        return result;
    }
    public void combination(String digits, int pos, HashMap<Character, String> m, StringBuilder sb, ArrayList<String> result){
        if(pos == digits.length())
            result.add(sb.toString());
        else {
            String chars = m.get(digits.charAt(pos));
            for(int i = 0; i < chars.length(); i++){
                sb.append(chars.charAt(i));
                combination(digits, pos + 1, m, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}