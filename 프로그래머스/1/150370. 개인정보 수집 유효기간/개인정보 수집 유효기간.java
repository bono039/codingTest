import java.util.*;

class Solution {
    static Map<String, String> map = new HashMap<>();
    static List<Integer> list = new ArrayList<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        // 문자와 그에 따른 기간 넣기
        for(String term : terms) {
            String[] str = term.split(" ");
            map.put(str[0], str[1]);
        }
        
        int YY = Integer.parseInt(today.split("\\.")[0]);
        int MM = Integer.parseInt(today.split("\\.")[1]);
        int DD = Integer.parseInt(today.split("\\.")[2]);
        
        // 개인정보 수집일자
        for(int i = 0 ; i < privacies.length ; i++) {
            String[] privacy = privacies[i].split(" ");
            String[] numbers = privacy[0].split("\\.");

            int type = Integer.parseInt(map.get(privacy[1])) * 28;
            
            int num = (YY - Integer.parseInt(numbers[0])) * 28 * 12
                    + (MM - Integer.parseInt(numbers[1])) * 28
                    + (DD - Integer.parseInt(numbers[2]));
            
            if(num >= type) {
                list.add(i + 1);
            }                         
        }      
        
        // 출력하기
        Collections.sort(list);
        int[] answer = new int[list.size()];  // 파기해야 할 개인정보 번호
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
