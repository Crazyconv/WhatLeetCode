public class CompareVersionNumbers{
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while(i < v1.length || i < v2.length){
        	Integer n1 = (i < v1.length)? Integer.parseInt(v1[i]) : 0;
        	Integer n2 = (i < v2.length)? Integer.parseInt(v2[i]) : 0;
        	int status = n1.compareTo(n2);
        	if(status != 0)
        		return status;
        	i++;
        }
        return 0;
    }	
}