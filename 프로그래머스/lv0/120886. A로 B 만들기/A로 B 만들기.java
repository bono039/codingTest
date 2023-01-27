import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {

        char[] beforeChars = before.toCharArray();
        char[] afterChars = after.toCharArray();
        
        Arrays.sort(beforeChars);
        Arrays.sort(afterChars);
        
        before = new String(beforeChars);
        after  = new String(afterChars);
        
        
        
//         String newStr = "";
        
//         for(int i = before.length()-1 ; i >=0  ; i--) {
//             newStr += String.valueOf(before.charAt(i));
//         }
        
         return (before.equals(after)) ? 1 : 0;
    }
}