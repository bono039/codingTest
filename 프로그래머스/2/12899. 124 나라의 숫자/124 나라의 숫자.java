class Solution {
    public String solution(int n) {
        String[] arr = {"4", "1", "2"};
        String answer = "";
        
        int num = n;
        while(num > 0) {
            int remainder = num % 3;
            num /= 3;
            
            if(remainder == 0)  num--;
            answer = arr[remainder] + answer;
        }        
        
        return answer;
    }
}