import java.util.HashSet;
import java.util.LinkedList;
import java.util.ArrayList;

public class WordLadder{
    public int shortestTransform(String start, String end, HashSet<String> dict){
        WordNode wn = new WordNode(start, 0);
        LinkedList<WordNode> q = new LinkedList<WordNode>();
        q.offer(wn);

        dict.add(end);
        dict.remove(start);

        wn = q.poll();
        while(wn != null){
            char[] charArray = wn.word.toCharArray();
            for(int i = 0; i < charArray.length; i++){
                char origin = charArray[i];
                for(char c = 'a'; c <= 'z'; c++){
                    if(origin != c){
                        charArray[i] = c;
                        String toWord = new String(charArray);
                        if(toWord.equals(end)){
                            return (wn.dist + 1);
                        }
                        if(dict.contains(toWord)){
                            WordNode newwn = new WordNode(toWord, wn.dist+1);
                            q.offer(newwn);
                            dict.remove(toWord);
                            if(dict.isEmpty())
                                return -1;
                        }
                    }
                }
                charArray[i] = origin;
            }
            wn = q.poll();
        }
        return -1;
    }

    public ArrayList<ArrayList<String>> allShortestTransform(String start, String end, HashSet<String> dict){
        ArrayList<ArrayList<String>> allShortestPath = new ArrayList<ArrayList<String>>();
        int minDist = -1;
        int preDist = 0;
        int currentDist = 0;
        HashSet<String> visited = new HashSet<String>();

        WordNode wn = new WordNode(start, 0, null);
        LinkedList<WordNode> q = new LinkedList<WordNode>();
        q.offer(wn);

        dict.add(end);
        dict.remove(start);

        wn = q.poll();
        while(wn != null){
            currentDist = wn.dist;
            if(minDist != -1 && currentDist > minDist){
                break;
            }
            if(currentDist > preDist){
                dict.removeAll(visited);
            }
            if(wn.word.equals(end)){
                minDist = wn.dist;
                ArrayList<String> oneShortestPath = new ArrayList<String>();
                while(wn != null){
                    oneShortestPath.add(wn.word);
                    wn = wn.prev;
                }
                allShortestPath.add(oneShortestPath);
            } else {
                if(minDist == -1){
                    char[] charArray = wn.word.toCharArray();
                    for(int i = 0; i < charArray.length; i++){
                        char origin = charArray[i];
                        for(char c = 'a'; c <= 'z'; c++){
                            if(origin != c){
                                charArray[i] = c;
                                String toWord = new String(charArray);
                                if(dict.contains(toWord)){
                                    WordNode newwn = new WordNode(toWord, wn.dist+1, wn);
                                    q.offer(newwn);
                                    visited.add(toWord);
                                }
                            }
                        }
                        charArray[i] = origin;
                    }
                }
            }
            preDist = currentDist;
            wn = q.poll();
        }
        return allShortestPath;        
    }

    public static void main(String[] argvs){
        WordLadder wl = new WordLadder();
        HashSet<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(wl.shortestTransform("hit", "cog", dict));
        // for(ArrayList<String> path: wl.allShortestTransform("hit", "cog", dict)){
        //     for(String s: path){
        //         System.out.print(s + " ");
        //     }
        //     System.out.println();
        // }
    }

    class WordNode{
        String word;
        int dist;
        WordNode prev; 
        public WordNode(String word, int dist, WordNode prev){
            this.word = word;
            this.dist = dist;
            this.prev = prev;
        }
        public WordNode(String word, int dist){
            this.word = word;
            this.dist = dist;
            this.prev = null;
        }
    }
}