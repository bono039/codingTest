import java.util.*;

class Solution {
    static HashMap<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(int i = 0 ; i < info.length ; i++) {
            String[] s = info[i].split(" ");
            makeSentence(s, 0, "");
        }
        
        for(String key : map.keySet())
            Collections.sort(map.get(key));
        
        for(int i = 0 ; i < query.length ; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            
            if(map.containsKey(q[0]))
                answer[i] = binarySearch(q[0], Integer.parseInt(q[1]));
            else
                answer[i] = 0;
        }        
        
        return answer;
    }
    
    private static void makeSentence(String[] strArr, int cnt, String str) {
        if(cnt == 4) {
            if(!map.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                map.put(str, list);
            }
            
            map.get(str).add(Integer.parseInt(strArr[4]));
            return;
        }
        
        makeSentence(strArr, cnt + 1, str + "-");
        makeSentence(strArr, cnt + 1, str + strArr[cnt]);
    }
    
    private static int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        
        int start = 0;
        int end = list.size() - 1;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }
        
        return list.size() - start;
    }
}