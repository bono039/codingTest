import java.util.*;
import java.io.*;

class Solution {
    static int[] elements;
    //static Deque<Integer> deque = new Deque<>();
    static Set<Integer> set = new HashSet<>();
    
    static int answer;
    
    public int solution(int[] elements) {
        this.elements = elements;
        answer = 0;
        
        // n개 뽑는 경우의 수
        for(int len = 0 ; len < elements.length ; len++) {
            // 슬라이딩 윈도우?
            for(int i = 0 ; i < elements.length ; i++) {
                solve(i, i + len);
                //System.out.println("range -> " + i + " " + (i+len));
            }
        }
        
        
        return set.size();
    }
    
    private static void solve(int a, int b) {
        int tmp = 0;
        
        for(int i = a ; i <= b ; i++) {
            tmp += elements[i % elements.length];
        }
        
        set.add(tmp);
        //System.out.println(tmp);
    }
}