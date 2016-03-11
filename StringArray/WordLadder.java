import java.util.HashSet;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class WordLadder{
    public int shortestTransform(String start, String end, HashSet<String> dict){
        WordNode wn = new WordNode(start, 1);
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
        return 0;
    }

    // public List<List<String>> allShortestTransform(String start, String end, HashSet<String> dict){
    //     List<List<String>> allShortestPath = new ArrayList<List<String>>();
    //     int minDist = -1;
    //     int preDist = 0;
    //     int currentDist = 0;
    //     HashSet<String> visited = new HashSet<String>();

    //     WordNode wn = new WordNode(start, 0, null);
    //     LinkedList<WordNode> q = new LinkedList<WordNode>();
    //     q.offer(wn);

    //     dict.add(end);
    //     dict.remove(start);

    //     wn = q.poll();
    //     while(wn != null){
    //         currentDist = wn.dist;
    //         if(minDist != -1 && currentDist > minDist){
    //             break;
    //         }
    //         if(currentDist > preDist){
    //             dict.removeAll(visited);
    //         }
    //         if(wn.word.equals(end)){
    //             minDist = wn.dist;
    //             ArrayList<String> oneShortestPath = new ArrayList<String>();
    //             while(wn != null){
    //                 oneShortestPath.add(wn.word);
    //                 wn = wn.prev;
    //             }
    //             Collections.reverse(oneShortestPath);
    //             allShortestPath.add(oneShortestPath);
    //         } else {
    //             if(minDist == -1){
    //                 char[] charArray = wn.word.toCharArray();
    //                 for(int i = 0; i < charArray.length; i++){
    //                     char origin = charArray[i];
    //                     for(char c = 'a'; c <= 'z'; c++){
    //                         if(origin != c){
    //                             charArray[i] = c;
    //                             String toWord = new String(charArray);
    //                             if(dict.contains(toWord)){
    //                                 WordNode newwn = new WordNode(toWord, wn.dist+1, wn);
    //                                 q.offer(newwn);
    //                                 visited.add(toWord);
    //                             }
    //                         }
    //                     }
    //                     charArray[i] = origin;
    //                 }
    //             }
    //         }
    //         preDist = currentDist;
    //         wn = q.poll();
    //     }
    //     return allShortestPath;        
    // }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> results = new ArrayList<List<String>>();
        LinkedList<WordNode> pre = new LinkedList<WordNode>();
        LinkedList<WordNode> cur = new LinkedList<WordNode>();
        Set<String> visited = new HashSet<String>();
        boolean find = false;

        dict.remove(start);
        dict.add(end);
        pre.add(new WordNode(start, 0, null));
        visited.add(start);
        while(!pre.isEmpty()){
            WordNode node = pre.poll();
            if(node.word.equals(end)){
                find = true;
                List<String> r = new ArrayList<String>();
                while(node != null){
                    r.add(node.word);
                    node = node.prev;
                }
                Collections.reverse(r);
                results.add(r);
            } else {
                // BFS
                char[] ca = node.word.toCharArray();
                for(int i = 0; i < ca.length; i++){
                    char temp = ca[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(temp != c){
                            ca[i] = c;
                            String newWord = new String(ca);
                            // System.out.println(newWord);
                            if(dict.contains(newWord)){
                                cur.add(new WordNode(newWord, node.dist+1, node));
                                visited.add(newWord);
                            }
                        }
                    }
                    ca[i] = temp;
                }
            }
            if(!find){
                if(pre.isEmpty()){
                    pre = cur;
                    cur = new LinkedList<WordNode>();
                    dict.removeAll(visited);
                }
            }
        }
        return results;
    }

    public static void main(String[] argvs){
        WordLadder wl = new WordLadder();
        HashSet<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        // System.out.println(wl.shortestTransform("hit", "cog", dict));
        for(List<String> path: wl.findLadders("hit", "cog", dict)){
            for(String s: path){
                System.out.print(s + " ");
            }
            System.out.println();
        }
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