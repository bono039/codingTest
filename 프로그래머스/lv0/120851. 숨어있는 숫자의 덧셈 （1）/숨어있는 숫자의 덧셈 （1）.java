class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String intStr = "";
        
        // for문으로 숫자 추출
        for(int i=0 ; i < my_string.length() ; i++) {
            char ch = my_string.charAt(i);
            
            // 0                 9
            if(48 <= ch && ch <= 57) {
                intStr += ch;
            }
        }
        
        // 숫자 더하기
        for(int i=0 ; i < intStr.length() ; i++) {
            answer += Integer.parseInt(String.valueOf(intStr.charAt(i)));
        }
        
        return answer;
    }
}