public class ExcelSheetColumnTitle{
    public String convertToTitle(int n) {
        int re = 0;
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            re = (n - 1) % 26;
            n = (n - 1) / 26;
            char c = (char)('A' + re);
            sb.insert(0, c);
        }
        return sb.toString();
    }    
}