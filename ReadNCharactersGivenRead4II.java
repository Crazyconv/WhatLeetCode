public class ReadNCharactersGivenRead4II{
    int charPointer = 0;
    int charNum = 0;
    boolean eof = false;
    char[] buffer = new char[4];
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int total = 0;
        while(charPointer < charNum && total < n)
            buf[total++] = buffer[charPointer++];

        while(total < n && !eof){
            if((charNum = read4(buffer)) < 4)
                eof = true;
            for(charPointer = 0; charPointer < charNum && total < n; )
                buf[total++] = buffer[charPointer++];
        }
        return total;
    }    
}