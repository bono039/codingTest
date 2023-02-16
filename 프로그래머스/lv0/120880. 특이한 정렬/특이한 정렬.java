import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        // 거리 차이 배열
        List<Integer> list = new ArrayList<>();
        Arrays.sort(numlist);
        
        // 탐색
        for(int num : numlist) list.add(num);
        
        list.sort((s1, s2) -> Integer.compare(Math.abs(s2 - n), Math.abs(s1 - n)));
        
        Collections.reverse(list);
        
        return list.stream().mapToInt(num -> num).toArray();
    }
}