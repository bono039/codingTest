class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i=0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            
            // 공백인 경우
            if(ch == ' ') {
                answer += ch;
                continue;
            }
            // 소문자인 경우
            if('a' <= ch && ch <= 'z') {
                if(ch + n > 'z')  answer += (char)(ch - 26 + n);
                else              answer += (char)(ch + n);
            }
            // 대문자인 경우
            else if ('A' <= ch && ch <= 'Z'){
                if(ch + n > 'Z')  answer += (char)(ch - 26 + n);
                else              answer += (char)(ch + n);
            }
        }
        
        return answer;
    }
}