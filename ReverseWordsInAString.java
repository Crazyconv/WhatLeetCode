public class ReverseWordsInAString{
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        System.out.println(words.length);
        int len = words.length;
        for(int i = len - 1; i >= 0; i --){
            sb.append(words[i]);
            if(i != 0)
                sb.append(" ");
        }
        return sb.toString();
    }    
    public static void main(String[] argvs){
        ReverseWordsInAString rwias = new ReverseWordsInAString();
        System.out.println(rwias.reverseWords("   a   b "));
    }
}