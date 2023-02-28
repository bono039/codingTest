class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int cntP = 0;
        int cntY = 0;
        
        for(int i=0 ; i < s.length() ; i++) {
            if(s.charAt(i) == 'P' || s.charAt(i) == 'p') cntP++;
            else if(s.charAt(i) == 'Y' || s.charAt(i) == 'y') cntY++;
        }

        answer = (cntP == cntY) ? true : false;
        
        return answer;
    }
}