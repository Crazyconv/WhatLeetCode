public class ExcelSheetColumnNumber{
    public int titleToNumber(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            result += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - i - 1);
        }
        return result;
    }    
}