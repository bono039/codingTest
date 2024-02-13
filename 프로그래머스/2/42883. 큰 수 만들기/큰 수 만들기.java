class Solution {    
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;    // 탐색 시작 idx
        int max = 0;
        
        for(int i = 0 ; i < number.length() - k ; i++) {
            max = 0;
            
            for(int j = idx ; j <= i + k ; j++) {
                if(max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    idx = j + 1;    // 가장 큰 수 다음 인덱스 넣기
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
}