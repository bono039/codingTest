import java.util.*;

class Solution {
    static char[] oper = {'+', '-', '*'};
    static char[] output = new char[3]; // 순열 결과 저장 배열
    static boolean[] chk = new boolean[3];

    static List<Long> numList = new LinkedList<>();         // 숫자 담을 리스트
    static List<Character> operList = new LinkedList<>();   // 연산자 담을 리스트
    
    static long answer = 0; // 우승 시 받을 수 잇는 가장 큰 상금 금액
        
    public long solution(String expression) {        
        String tmp = "";
        
        for(char c : expression.toCharArray()) {
            if(Character.isDigit(c)) {
                tmp += c;
            }
            else {
                numList.add(Long.parseLong(tmp));
                tmp = "";
                operList.add(c);
            }
        }
        numList.add(Long.parseLong(tmp));   // 마지막 문자 삽입
        
        dfs(0);
        return answer;
    }
    
    // 순열 만드는 메서드
    private static void dfs(int depth) {
        if(depth == 3) {
            solve();
            return;
        }
        
        for(int i = 0 ; i < 3 ; i++) {
            if(!chk[i]) {
                chk[i] = true;
                output[depth] = oper[i];
                dfs(depth + 1);
                chk[i] = false;
            }
        }
    }
    
    // 연산
    private static void solve() {
        List<Long>   num = new LinkedList<>();
        List<Character> oper = new LinkedList<>();
                
        num.addAll(numList);
        oper.addAll(operList);
        
        for(int i = 0 ; i < 3 ; i++) {
            char nowOp = output[i];   // 현재 우선순위 연산자
            
            for(int j = 0 ; j < oper.size() ; j++) {
                if(oper.get(j).equals(nowOp)) { // 현재 우선순위 연산자와 맞는 경우
                    long n1 = num.get(j);
                    long n2 = num.get(j + 1);
                    long res = calc(n1, n2, nowOp);
                    
                    num.remove(j + 1);  // 숫자 삭제
                    num.remove(j);
                    oper.remove(j);     // 연산자 삭제
                    
                    num.add(j, res);    // 연산 결과 넣기
                    
                    j--;    // 삭제했으니 인덱스 하나 줄이기
                }
            }
        }
        
        answer = Math.max(answer, Math.abs(num.get(0)));
    }
    
    // 수식 계산
    private static long calc(Long a, Long b, char c) {
        long result = 0;
        
        switch(c) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
        }
        
        return result;        
    }
}