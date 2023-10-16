import java.util.*;
// 조합 백트래킹
class Solution {
    static String numbers;
    static List<Integer> answer = new ArrayList<>();  // 소수 집합 (중복 제거)
    static boolean[] visited = new boolean[7];
    
    public int solution(String numbers) {
        this.numbers = numbers;
        
        // 몇 자리 수 만들건지
        for(int i = 0 ; i < numbers.length() ; i++) {
            back("", 0, i + 1);
        }
        return answer.size();
    }
    
    private static void back(String str, int depth, int goal) {
        if(depth == goal) {
            int tmp = Integer.parseInt(str);
            
            if(!answer.contains(tmp) && isPrime(tmp)) {
                answer.add(tmp);
                System.out.println(tmp);
            }
            return;
        }
        
        // numbers의 한 글자씩 브루트포스....
        for(int i = 0 ; i < numbers.length() ; i++) {
            if(!visited[i]) {
                str += numbers.charAt(i);   // 임시 변수에 붙이며 숫자 조합 생성
                
                visited[i] = true;
                back(str, depth + 1, goal);
                visited[i] = false;
                
                str = str.substring(0, str.length() - 1);   // 이전 상태로 돌아가고자 마지막 자리 숫자 제외하고 갱신
            }
            
                
        }
    }
    
    // 소수 판별 메소드
    private static boolean isPrime(int num) {
        if(num <= 1) return false;
        
        for(int i = 2 ; i * i <= num ; i++) {
            if(num % i == 0)    return false;
        }
        return true;
    }
}