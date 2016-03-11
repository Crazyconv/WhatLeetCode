public class WordBreakII{
    // 5ms
    // iterative method to calculate db
    // db maintains word interval
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict.size() == 0)
            return new ArrayList<String>();

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length() && !dp[i]; i++){
            for(int j = i - 1; j >= 0; j--){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        if(!dp[s.length()])
            return new ArrayList<String>();
            
        ArrayList<ArrayList<ArrayList<Integer>>> db = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for(int i = 0; i < s.length(); i++){
            db.add(new ArrayList<ArrayList<Integer>>());
        }
        for(int i = 0; i < s.length(); i++){
            if(wordDict.contains(s.substring(0, i+1))){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(0); temp.add(i+1);
                db.get(i).add(temp);
            }
            for(int j = i - 1; j >= 0; j--){
                if(db.get(j).size() > 0){
                    String part = s.substring(j+1, i+1);
                    if(wordDict.contains(part)){
                        for(ArrayList<Integer> item: db.get(j)){
                            ArrayList<Integer> newItem = new ArrayList<Integer>(item);
                            newItem.add(j+1); newItem.add(i+1);
                            db.get(i).add(newItem);
                        }
                    }
                }
            }
        }

        ArrayList<String> result = new ArrayList<String>();
        for(ArrayList<Integer> item: db.get(s.length()-1)){
            StringBuilder part = new StringBuilder();
            for(int i = 0; i < item.size(); i += 2){
                if(i != 0)
                    part.append(" ");
                part.append(s.substring(item.get(i), item.get(i+1)));
            }
            result.add(part.toString());
        }
        return result;      
    }

    // 6ms
    // iterative method to calculate db
    // db maintains position of last break (recursive)
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict.size() == 0)
            return new ArrayList<String>();

        // without this section, time limit exceeded. 
        // some test case does not have valid partiiton, but takes a lot of time and space
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length() && !dp[i]; i++){
            for(int j = i - 1; j >= 0; j--){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        if(!dp[s.length()])
            return new ArrayList<String>();

        ArrayList<ArrayList<Integer>> db = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < s.length(); i++){
            db.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < s.length(); i++){
            if(wordDict.contains(s.substring(0, i+1))){
                db.get(i).add(0);
            }
            for(int j = i - 1; j >= 0; j--){
                if(db.get(j).size() > 0){
                    String part = s.substring(j+1, i+1);
                    if(wordDict.contains(part)){
                        db.get(i).add(j+1);
                    }
                }
            }
        }

        return getString(s, s.length() - 1, db);        
    }
    public ArrayList<String> getString(String s, int pos, ArrayList<ArrayList<Integer>> db){
        ArrayList<String> result = new ArrayList<String>();
        for(Integer last : db.get(pos)){
            if(last == 0)
                result.add(s.substring(0, pos+1));
            else{
                for(String str : getString(s, last-1, db)){
                    result.add(str + " " + s.substring(last, pos+1));
                }
            }
        }
        return result;
    }  

    // 4ms
    // recursive method to calculate db (because we already have dp, we can cut links. iterative method incurs unused subsolution)
    // db maintains word interval
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict.size() == 0)
            return new ArrayList<String>();

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length() && !dp[i]; i++){
            for(int j = i - 1; j >= 0; j--){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        if(!dp[s.length()])
            return new ArrayList<String>();
            
        ArrayList<ArrayList<ArrayList<Integer>>> db = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for(int i = 0; i < s.length(); i++){
            db.add(new ArrayList<ArrayList<Integer>>());
        }
        wordBreak(s, wordDict, s.length() - 1, dp, db);

        ArrayList<String> result = new ArrayList<String>();
        for(ArrayList<Integer> item: db.get(s.length()-1)){
            StringBuilder part = new StringBuilder();
            for(int i = 0; i < item.size(); i += 2){
                if(i != 0)
                    part.append(" ");
                part.append(s.substring(item.get(i), item.get(i+1)));
            }
            result.add(part.toString());
        }
        return result;      
    }  
    public void wordBreak(String s, Set<String> wordDict, int i, boolean[] dp, ArrayList<ArrayList<ArrayList<Integer>>> db){
        if(wordDict.contains(s.substring(0, i+1))){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(0); temp.add(i+1);
            db.get(i).add(temp);
        }
        for(int j = i - 1; j >= 0; j--){
            if(dp[j+1] && wordDict.contains(s.substring(j+1,i+1))){
                if(db.get(j).size() == 0)
                    wordBreak(s, wordDict, j, dp, db);
                for(ArrayList<Integer> item: db.get(j)){
                    ArrayList<Integer> newItem = new ArrayList<Integer>(item);
                    newItem.add(j+1); newItem.add(i+1);
                    db.get(i).add(newItem);
                }                
                break;
            }
        }
    }
}