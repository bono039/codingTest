import java.util.*;
// 각 조각에 동일한 가짓수 토핑이 올라가면 공평하게 롤케이크가 나눠진 것으로 생각
class Solution {
    public int solution(int[] topping) {
        int answer = 0; // 롤케이크 공평하게 자르는 방법의 수
        int size = topping.length;
        
        Set<Integer> first = new HashSet<>();
        Map<Integer, Integer> second = new HashMap<>();
        
        first.add(topping[0]);
        for(int i = 1 ; i < size ; i++) {
            second.put(topping[i], second.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i = 1 ; i < size ; i++) {
            first.add(topping[i]);
            second.put(topping[i], second.get(topping[i]) - 1);
            
            if(second.get(topping[i]) == 0) {
                second.remove(topping[i]);
            }
            
            if(first.size() == second.size())   answer++;
        }
                
        return answer;
    }
}