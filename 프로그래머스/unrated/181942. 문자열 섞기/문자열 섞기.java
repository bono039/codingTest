class Solution {
    public String solution(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < str1.length() ; i++) {
            sb.append(str1.substring(i, i+1)).append(str2.substring(i, i+1));
        }
        
        return sb.toString();
    }
}