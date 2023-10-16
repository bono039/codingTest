import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] str = new String[numbers.length];  // 문자열 리턴 할 문자열 배열
        for(int i = 0 ; i < numbers.length ; i++) {
            str[i] = Integer.toString(numbers[i]);
        }
        
        // 내림차순 정렬 (앞자릿수가 큰 순으로 정렬하고 붙이기)
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);    // 오름차순 정렬 : (a+b).compareTo(a+b);
            }
        });
        
        // 첫 번쨰 값이 0인 경우, 0 리턴
        if(str[0].equals("0"))  return "0";
        
        String answer = "";
        for(String s : str)  {
            answer += s;
        }
        
        return answer;
    }
}