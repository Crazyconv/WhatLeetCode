public class RestoreIPAddresses{
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String> ();
        ipPart(s, 0, 1, "", result);
    }  
    public void ipPart(String s, int start, int pn, String part, ArrayList<String> result){
        if(pn == 4){
            if(s.length() - start == 1 || s.charAt(start) != '0' && (s.length() - start < 3 || s.substring(start).compareTo("255") <= 0)){
                result.add(part + s.substring(start));
            }
        } else {
            for(int i = 1; i <= 3; i++){
                int remainN = s.length() - 1 - start - i;
                if(remainN >= 4 - pn && remainN <= 3 * (4 - pn)){
                    if(i == 1 || s.charAt(start) != '0' && (i < 3 || s.substring(start, start + i).compareTo("255") <= 0)){
                        ipPart(s, start + i, pn + 1, part + s.substring(start, start + i) + ".", result);
                    }
                }
            }
        }
    }
    // public List<String> restoreIpAddresses(String s) {
    //     ArrayList<String> result = new ArrayList<String> ();
    //     int minLeftLength = 2;
    //     int maxLeftLength = 6;
    //     if (s.length() > 8)
    //         minLeftLength = s.length() - 6;
    //     else
    //         maxLeftLength = s.length() - 2;
    //     for (int leftLength = minLeftLength; leftLength <= maxLeftLength; leftLength++){
    //         ArrayList<String> left = ipPart(s, 0, leftLength - 1);
    //         ArrayList<String> right = ipPart(s, leftLength, s.length() - 1);
    //         for (String l : left){
    //             for (String r : right){
    //                 result.add(l + "." + r);
    //             }
    //         }
    //     }
    //     return result;
    // }    
    // public ArrayList<String> ipPart(String s, int start, int end){
    //     ArrayList<String> result = new ArrayList<String> ();
    //     int minLeftLength = 1;
    //     int maxLeftLength = 3;
    //     if(end - start > 3)
    //         minLeftLength = end - start -2;
    //     else
    //         maxLeftLength = end - start;
    //     for(int leftLength = minLeftLength; leftLength <= maxLeftLength; leftLength++){
    //         String leftPart = s.substring(start, start + leftLength);
    //         boolean left = (leftLength == 1 || s.charAt(start) != '0' && (leftLength < 3 || leftPart.compareTo("255") <= 0));
    //         String rightPart = s.substring(start + leftLength, end + 1);
    //         boolean right = (end - start + 1 - leftLength == 1 || s.charAt(start + leftLength) != '0' && (end - start + 1 - leftLength < 3 || rightPart.compareTo("255") <= 0));
    //         if(left && right)
    //             result.add(leftPart + "." + rightPart);
    //     }
    //     return result;
    // }
}