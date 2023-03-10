class Solution {
    public int solution(int[] number) {

        int len = number.length;
        int answer = 0;
        
        for(int i = 0 ; i < len-2 ; i++) {
            for(int j = i+1 ; j < len-1 ; j++) {
                for(int k = j+1 ; k < len ; k++) {
                    if(number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}