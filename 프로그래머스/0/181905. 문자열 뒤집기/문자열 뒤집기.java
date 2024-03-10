class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(my_string.substring(0, s));
        
        StringBuilder tmp = new StringBuilder();
        tmp.append(my_string.substring(s, e + 1));
        
        sb.append(tmp.reverse());
        sb.append(my_string.substring(e+1));
        
        return sb.toString();
    }
}