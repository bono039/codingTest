import java.util.*;

class Solution {
    public String solution(String p) {                
        if(check(p))
            return p;
        return solve(p);
    }
    
    // 올바른 괄호 문자열 판단 메서드
    private static boolean check(String s) {
        int cnt = 0;
        
        for(char c : s.toCharArray()) {
            if(c == '(') {
                cnt++;
            }
            else {
                cnt--;

                if(cnt < 0) return false;
            }
        }
        
        return true;
    }
    
    // 균형잡힌 괄호 문자열 -> 올바른 괄호 문자열 변환ㅁ ㅔ서드
    private static String solve(String w) {
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        if(w.length() == 0)   return "";
        
        int open = 0;   // '(' 개수
        
        for(int i = 0 ; i < w.length() ; i++) {
            if(w.charAt(i) == '(') open++;
            else open--;
            
            if(open == 0) { // 균형잡힌 괄호 문자열
                u.append(w.substring(0, i + 1));
                v.append(w.substring(i + 1));
                
                if(check(u.toString())) {   // u가 올바른 괄호 문자열이라면
                    u.append(solve(v.toString()));
                }
                else {
                    StringBuilder tmp = new StringBuilder();
                    tmp.append("(");
                    tmp.append(solve(v.toString()));    // v에 대해 재귀호출 후 붙이기
                    tmp.append(")");
                    tmp.append(reverse(u.toString()));  // u 조작해 붙이기

                    return tmp.toString();  // 새 문자열 반환                    
                }
                
                break;
            }
        }
        
        return u.toString();    // u가 올바른 괄호 문자열인 경우에만 도달
    }
    
    // 변환하는 메서드
    private static String reverse(String str) {
        StringBuilder s = new StringBuilder();
        
        // 앞뒤 두 문자 제외하고 변환
        for(int i = 1 ; i < str.length() - 1 ; i++) {
            s.append(str.charAt(i) == '(' ? ')' : '(');
        }
        
        return s.toString();
    }
}