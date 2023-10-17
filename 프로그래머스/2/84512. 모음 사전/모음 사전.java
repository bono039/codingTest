import java.util.*;

class Solution {    
    static String[] vowels = {"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();   // 알파벳 모음 집합
    
    public int solution(String word) {
        
        comb("", 0);
        
        return list.indexOf(word);
    }
    
    // 조합 메소드
    private static void comb(String str, int depth) {
        list.add(str);
        
        if(depth == 5) return;
        
        for(int i = 0 ; i < vowels.length ; i++) {
            comb(str + vowels[i], depth + 1);  // 재귀 호출
        }
    }
}