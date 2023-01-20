class Solution {
    public int solution(int n, int k) {
        
        int total = 0;
        int minus = 0;
        
        /* 서비스 음료수 갯수 계산 */
        if(n >= 10) {
            minus = n/10;
        }
        
        total = 12000 * n + 2000 * k - 2000 * minus;
        return total;
    }
}