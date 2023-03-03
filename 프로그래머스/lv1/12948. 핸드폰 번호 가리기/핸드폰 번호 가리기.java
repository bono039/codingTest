class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        int len = phone_number.length();
        
        for(int i=0 ; i < len ; i++) {
            if(0 <= i && i < len -4)
                answer += "*";
            else 
                answer += String.valueOf(phone_number.charAt(i));
        }
        
        return answer;
    }
}