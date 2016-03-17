public class ReverseWordsInAStringII{
    public void reverseWords(char[] s) {
    	reverse(s, 0, s.length - 1);
    	int start = 0;
    	for(int i = 1; i <= s.length; i++){
    		if(i == s.length || s[i] == ' '){
    			reverse(s, start, i - 1);
    			start = i + 1;
    			i ++;
    		}
    	}
    }	
    public void reverse(char[] s, int start, int end){
    	while(start < end){
    		char temp = s[start];
    		s[start] = s[end];
    		s[end] = temp;
    		start ++;
    		end --;
    	}
    }
    public static void main(String[] argvs){
    	ReverseWordsInAStringII rw = new ReverseWordsInAStringII();
    	char[] s = "t".toCharArray();
    	rw.reverseWords(s);
    	for(Character c : s){
    		System.out.print(c);
    	}
    }
}