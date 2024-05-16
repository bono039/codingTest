import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        
        int infoNum = getNum(ext);
        int sortNum = getNum(sort_by);
        
        for(int i = 0 ; i < data.length ; i++) {
            if(data[i][infoNum] < val_ext) {
                list.add(data[i]);
            }
        }
        Collections.sort(list, (o1, o2) -> o1[sortNum] - o2[sortNum]);
        
        int[][] answer = new int[list.size()][4];
        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private static int getNum(String str) {
        switch(str) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
        }
        return 0;
    }
}