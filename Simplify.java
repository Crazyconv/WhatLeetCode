public class SimplifyPath{
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        int[] pre = new int[parts.length];
        int pos = -1;
        for(int i = 0; i < parts.length; i++){
        	if(parts[i].equals("..")){
        		if(pos != -1)
        			pos = pre[pos];
        	} else if(!parts[i].equals(".") && !parts[i].equals("")){
        		pre[i] = pos;
        		pos = i;
        	}
        }
        if(pos == -1)
            return "/";
        ArrayList<String> arr = new ArrayList<String>();
        while(pos != -1){
        	arr.add(parts[pos]);
        	pos = pre[pos];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = arr.size() - 1; i >= 0; i--){
        	sb.append("/").append(arr.get(i));
        }
        return sb.toString();
    }
}