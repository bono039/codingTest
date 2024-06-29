class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        
        for(int i = 1 ; i <= included.length ; i++) {
            int x = a + (i-1) * d;
            
            if(included[i-1])
                answer += x;
        }
        return answer;
    }
}