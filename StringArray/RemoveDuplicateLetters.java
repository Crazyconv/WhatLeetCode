public class RemoveDuplicateLetters{
    // use stack
    // can use array to simulate stack
    // 5 ms
    // O(n): each character is push and pop from stack at most once
    public String removeDuplicateLetters(String s) {
        int[] remain = new int[26];
        boolean[] inStack = new boolean[26];
        for(int i = 0; i < s.length(); i++){
            remain[(int) s.charAt(i) - 'a'] ++;
        }

        char[] st = new char[26];
        int next = 0;
        for(int i = 0; i < s.length(); i++){
            int index = (int) s.charAt(i) - 'a';
            if(!inStack[index]){
                while(!st.isEmpty() && st.peek() > s.charAt(i) && remain[(int)st.peek() - 'a'] > 0){
                    next --;
                    inStack[(int) c - 'a'] = false;
                }
                st[next] = s.charAt(i);
                next ++;
                inStack[index] = true;
            }
            remain[index] --;
        }

        return new String(st).substring(0, next);
    }     
}