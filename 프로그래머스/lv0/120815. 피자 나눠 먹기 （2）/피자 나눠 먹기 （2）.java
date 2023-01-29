class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 6 12 18 24 30
        
        // 6    : 6*1  -> 6조각.  1판
        // 10   : 10*3 -> 30조각. 5판
        // 4    : 4*3  -> 12조각. 2판   
        
        // 조각 (i)을 1부터 ++해가면서
        // n * i % 6 == 0 이면
        // return n * i / 6 
        for(int i=1 ; i<=n ; i++) {
            if(6 * i % n == 0) {
                answer = i;
                break;
            }
        }
        
        
        return answer;
    }
}