class Solution {
    // 최대공약수 계산
    public static int gcd(int numer1, int numer2) {
        if(numer2 == 0) return numer1;
        else            return gcd(numer2, numer1 % numer2);
    }
    
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        int boonja = numer1 * denom2 + numer2 * denom1;
        int boonmo = denom1 * denom2;
        
        int gcd = gcd(boonja, boonmo);
        
        answer[0] = boonja / gcd;   // 분자
        answer[1] = boonmo / gcd;   // 분모
        
        return answer;
    }
}