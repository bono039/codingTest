class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        String str = ""; 
        
        for(int t=i ; t<=j ; t++) {
            str += Integer.toString(t);
        }
        
        for(int t=0; t<str.length() ; t++) {
            if(str.charAt(i) == 'k') answer++;
        }
        
        return answer;
    }
}