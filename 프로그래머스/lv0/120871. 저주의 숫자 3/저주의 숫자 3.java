class Solution {
    public int solution(int n) {
        int answer = n;
//         int i = 1;
        
//         while(i <= answer) {
//             if((i % 3 == 0) || String.valueOf(i).contains("3")) {
//                 answer++;
//             }
//             i++;
//         }
        
        for(int i=1 ; i<= answer ; i++) {
            if((i % 3 == 0) || String.valueOf(i).contains("3")) {
                 answer++;
             }
        }
        
        return answer;
    }
}