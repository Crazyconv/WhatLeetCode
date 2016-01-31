public class BullsAndCows{
    public String getHint(String secret, String guess) {
        int[] counts = new int[10];
        for(int i = 0; i < secret.length(); i++){
            counts[(int) secret.charAt(i) - '0'] ++;
        }

        int bull = 0, cow = 0;
        for(int i = 0; i < guess.length(); i++){
            char c = guess.charAt(i);
            int index = (int) c - '0';
            if(secret.charAt(i) == c){
                bull ++;
                if(counts[index] > 0)
                    counts[index] --;
                else
                    cow --;
            } else if(counts[index] > 0){
                counts[index] --;
                cow ++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bull).append('A').append(cow).append('B');
        return sb.toString();
    }    
}