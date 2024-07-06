import java.util.*;

class Solution {
    public String solution(String new_id) {
        
        // step1.
        new_id = new_id.toLowerCase();
        
        // step2.
        StringBuilder sb = new StringBuilder();
        for(char c : new_id.toCharArray()) {
            if(c >= 'a' && c <= 'z')        sb.append(c);
            else if(Character.isDigit(c))   sb.append(c);
            else if(c == '-' || c == '_' || c == '.')   sb.append(c);
        }
        
        // step3.
        String newStr = sb.toString().replaceAll("\\.{2,}", ".");
        
        // step4.
        if(newStr.startsWith("."))
            newStr = newStr.substring(1);
        
        if(newStr.endsWith("."))
            newStr = newStr.substring(0, newStr.length()-1);
        
        // step5.
        if(newStr.length() == 0)
            newStr = "a";
        
        // step6.
        if(newStr.length() >= 16) {
            newStr = newStr.substring(0, 15);
            
            if(newStr.endsWith("."))
                newStr = newStr.substring(0, newStr.length()-1);
        }        
        
        // step7.
        if(newStr.length() <= 2) {
            char c = newStr.charAt(newStr.length() - 1);
            while(newStr.length() < 3) {
                newStr += c;
            }
        }
        return newStr;
    }
}