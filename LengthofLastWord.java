public class LengthofLastWord{
    public static void main(String[] agrvs){
        LengthofLastWord llw = new LengthofLastWord();
        System.out.println(llw.lengthOfLastWord("Hello World"));
    }
    public int lengthOfLastWord(String s) {
        String[] parts = s.split(" ");
        if(parts.length > 0){
            return parts[parts.length - 1].length();
        }
        else
            return 0;
    }
}