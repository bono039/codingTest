import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String bin = Integer.toBinaryString(n);
        
        // n에서 1의 갯수 구하기
        int nCnt = 0;
        for(int i = 0 ; i < bin.length() ; i++) {
            if(bin.charAt(i) == '1') {
                nCnt++;
            }
        }
        
        for(int i = n + 1 ;  ; i++) {
            String tmpBin = Integer.toBinaryString(i);
            int tmpCnt = 0;
            
            for(int j = 0 ; j < tmpBin.length() ; j++) {
                if(tmpBin.charAt(j) == '1') {
                    tmpCnt++;
                }
            }
            
            if(tmpCnt == nCnt) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}