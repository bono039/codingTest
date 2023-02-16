class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "";
        
        // 2진수 -> 10진수
        int binToDeciaml1 = Integer.parseInt(bin1, 2);
        int binToDeciaml2 = Integer.parseInt(bin2, 2);
        
        int sum = binToDeciaml1 + binToDeciaml2;
        
        // 10진수 -> 2진수
        answer = Integer.toBinaryString(sum);
            
        return answer;
    }
}