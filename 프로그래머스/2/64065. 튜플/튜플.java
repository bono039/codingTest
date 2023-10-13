import java.util.*;
import java.util.stream.Stream; // 얘를 꼭 작성해줘야 한다.

class Solution {
    public int[] solution(String s) {
        List<Integer> list = new ArrayList<>();
        
        // 1. 불필요한 문자들 벗기기
        String[] strArr = s.split("},");
        for(int i = 0 ; i < strArr.length ; i++) {
            String ss = strArr[i].replace("{", "").replace("}", "");
            strArr[i] = ss;
        }
        
        // 2. 원소 개수가 적은 것부터 정렬하고 실행하기
        Arrays.sort(strArr, (a, b) -> Integer.compare(a.length(), b.length()));

        // 3. 만약에 원소 집합에 있는 값이라면 패스하고, 없으면 정답 리스트에 추가하기
        Set<Integer> duplicate = new HashSet<>();   // 원소 집합 (중복 제거)
        List<Integer> ans = new ArrayList<>();      // 정답 리스트
        
        for(String ss : strArr) {
            
            int[] tuple = Stream.of(ss.split(",")).mapToInt(Integer::parseInt).toArray();
            
            for(int i = 0 ; i < tuple.length ; i++) {
                if(!duplicate.contains(tuple[i])) { // 중복된 값이 아니라면, 정답 리스트에 해당 원소 추가
                    ans.add(tuple[i]);
                }
                
                duplicate.add(tuple[i]);
            }
        }
        
        // 4. 결과 int형 배열로 출력하기
        int[] result = new int[ans.size()];
        for(int i = 0 ; i < result.length ; i++) {
            result[i] = ans.get(i);
        }
        
        return result;
    }
}