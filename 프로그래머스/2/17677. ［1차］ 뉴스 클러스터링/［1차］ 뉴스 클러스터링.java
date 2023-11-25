import java.util.*;
// 자카드 유사도 : 두 집합의 교집합 크기 / 두 집합의 합집합 크기
// 둘다 공집합이면 1
// 원소 중복 허용하는 다중집합 -> 교집합 : Math.min() / 합집합 : Math.max()
class Solution {
    public int solution(String str1, String str2) {
        // 다 대문자로 만들기
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> intersect = new ArrayList<>();
        List<String> union = new ArrayList<>();
        
        for(int i = 0 ; i < str1.length() - 1 ; i++) {
            if('A' <= str1.charAt(i) && str1.charAt(i) <= 'Z' && 'A' <= str1.charAt(i + 1) && str1.charAt(i + 1) <= 'Z')
                list1.add(str1.substring(i, i + 2));
        }
        for(int i = 0 ; i < str2.length() - 1;  i++) {
            if('A' <= str2.charAt(i) && str2.charAt(i) <= 'Z' && 'A' <= str2.charAt(i + 1) && str2.charAt(i + 1) <= 'Z')
                list2.add(str2.substring(i, i + 2));
        }
        
        // 중복 원소 처리 위한 정렬
        Collections.sort(list1);
        Collections.sort(list2);
        
        // 교집합 구하기
        for(String s : list1) {
            if(list2.remove(s)) {
                intersect.add(s);
            }
            union.add(s);
        }
        
        // 합집합 구하기
        for(String s : list2) {
            union.add(s);
        }
        
        // 자카드 유사도 구하기        
        double jakard = 0;
        
        if(union.size() == 0) {
            jakard = 1;
        }
        else {
            jakard = (double) intersect.size() / (double) union.size();
        }
        
        return (int) (jakard * 65536);
    }
}