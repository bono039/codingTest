class Solution {
    public String solution(int age) {
        
        String strAge = Integer.toString(age);
        String answer = "";
        
        for(int i=0 ; i < strAge.length() ; i++) {
            if(strAge.charAt(i) == '0')      answer += "a";
            else if(strAge.charAt(i) == '1') answer += "b";
            else if(strAge.charAt(i) == '2') answer += "c";
            else if(strAge.charAt(i) == '3') answer += "d";
            else if(strAge.charAt(i) == '4') answer += "e";
            else if(strAge.charAt(i) == '5') answer += "f";
            else if(strAge.charAt(i) == '6') answer += "g";
            else if(strAge.charAt(i) == '7') answer += "h";
            else if(strAge.charAt(i) == '8') answer += "i";
            else if(strAge.charAt(i) == '9') answer += "j";
        }
        
        return answer;
    }
}