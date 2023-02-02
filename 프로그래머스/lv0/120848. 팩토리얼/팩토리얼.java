class Solution {
    public int solution(int n) {
        int answer = 1;
        int prod = 1;
        
        for(int i=1 ; i <= 10 ; i++) {
            if(prod * i <= n) {
                prod *= i;
                answer = i;
            }
        }
        
        return answer;
    }
}