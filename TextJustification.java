import java.util.*;
public class TextJustification{
    public List<String> fullJustify(String[] words, int maxWidth) {
    	ArrayList<String> result = new ArrayList<String>();
        int pos = 0;
        while(pos < words.length){
        	int lenSum = 0;
        	int start = pos;
        	while(pos < words.length && lenSum + words[pos].length() <= maxWidth){
        		lenSum += words[pos].length() + 1;
        		pos ++;
        	}
        	char[] cs = new char[maxWidth];
        	Arrays.fill(cs, ' ');
        	if(pos == words.length || pos == start + 1){
        		int index = 0;
        		for(int i = start; i < pos; i++){
        			for(int j = 0; j < words[i].length(); j++){
        				cs[index++] = words[i].charAt(j);
        			}
        			index ++;
        		}
        	} else {
        		int space = (maxWidth + 1 - lenSum) / (pos - start - 1);
        		int more = maxWidth + 1 - lenSum - space * (pos - start - 1);
        		int index = 0;
        		for(int i = start; i < pos; i ++){
        			for(int j = 0; j < words[i].length(); j++) {
        				cs[index++] = words[i].charAt(j);
        			}
        			index += space + 1;
        			if(more != 0){
        				index ++;
        				more --;
        			}
        		} 
        	}
        	result.add(new String(cs));
        }
        return result;
    }	
    public static void main(String[] argvs){
    	TextJustification t = new TextJustification();
    	String[] ss = {"This", "is", "an", "example", "ofrrrrrr", "text", "justification."};
    	for(String s : t.fullJustify(ss, 15)){
    		System.out.println(s);
    	}
    }
}