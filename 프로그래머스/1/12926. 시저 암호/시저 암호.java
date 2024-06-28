import java.util.*;

class Solution {    
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        
        for(int i = 0 ; i < ch.length ; i++) {
            if(ch[i] == ' ')
                sb.append(' ');
            else if('a' <= ch[i] && ch[i] <= 'z')
                sb.append((char)('a' + (ch[i] - 'a' + n) % 26));
            else if('A' <= ch[i] && ch[i] <= 'Z')
                sb.append((char)('A' + (ch[i] - 'A' + n) % 26));
        }
        
        return sb.toString();
    }
}