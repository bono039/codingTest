class Solution {
    public String solution(String my_string, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append(my_string.repeat(k));
        return sb.toString();
    }
}