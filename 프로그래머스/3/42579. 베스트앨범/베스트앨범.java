import java.util.*;
// 속한 노래 많이 재생된 장르 > 장르 내 많이 재생된 노래 > 고유 번호가 낮은 노래 순
class Solution {
    public int[] solution(String[] genres, int[] plays) {   // 장르, 재생 횟수

        /*** Map 생성해서 값 저장하기 ***/
        // 1. <장르, 재생횟수> 저장용 map    // 재생횟수 기준 내림차순 정렬
        Map<String, Integer> map1 = new HashMap<>();
        for(int i = 0 ; i < genres.length ; i++) {
            map1.put(genres[i], map1.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 2. <인덱스, 재생횟수> 저장용 map    // 고유번호 기준 내림차순 정렬
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i = 0 ; i < plays.length ; i++) {
            map2.put(i, plays[i]);
        }
        
        /*** 정렬 ***/
        // 1. 장르별로 모아둔 Map, 재생횟수 기준 내림차순 정렬
        List<String> genreList = new ArrayList<>(map1.keySet());
        Collections.sort(genreList, (o1, o2) -> map1.get(o2).compareTo(map1.get(o1)));
        
        // 2. 인덱스와 재생횟수 모아둔 Map, 인덱스 기준 내림차순 정렬
        List<Integer> indexList = new ArrayList<>(map2.keySet());
        Collections.sort(indexList, (o1, o2) -> map2.get(o2).compareTo(map2.get(o1)));
        
        
        /*** 정답 리스트 구하기 ***/
        List<Integer> answerList = new ArrayList<>();
        for(String g : genreList) {
            int cnt = 1;
            
            for(int i : indexList) {
                if(genres[i].equals(g) && cnt < 3) {    // 장르가 같고, Top2 안에 들면 정답 리스트에 넣음
                    cnt++;
                    answerList.add(i);
                }
            }
        }       
        
        
        return answerList.stream().mapToInt(i->i).toArray();    // 리스트를 배열로 변환
    }
}