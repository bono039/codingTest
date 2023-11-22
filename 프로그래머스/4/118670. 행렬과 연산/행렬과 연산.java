import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        
        Deque<Integer> start = new ArrayDeque<>();
        Deque<Deque<Integer>> mid = new ArrayDeque<>();
        Deque<Integer> end = new ArrayDeque<>();
        
        for(int[] row : rc) {
            start.add(row[0]);
            mid.add(new ArrayDeque<Integer>(
                IntStream
                    .of(Arrays.copyOfRange(row, 1, row.length - 1))
                    .boxed()
                    .collect(Collectors.toList())
                )
            );
            
            end.add(row[row.length - 1]);
        }
        
        for(String op : operations) {
            if(op.equals("Rotate")) {
                mid.getFirst().addFirst(start.removeFirst());
                end.addFirst(mid.getFirst().removeLast());
                mid.getLast().addLast(end.removeLast());
                start.addLast(mid.getLast().removeFirst());
            }
            else if(op.equals("ShiftRow")) {
                start.addFirst(start.removeLast());
                mid.addFirst(mid.removeLast());
                end.addFirst(end.removeLast());
            }
        }
        
        int[][] answer = new int[rc.length][rc[0].length];
        for(int i = 0 ; i < rc.length ; i++) {
            answer[i][0] = start.remove();
            
            Deque<Integer> midRow = mid.remove();
            
            for(int j = 1 ; j < rc[0].length - 1 ; j++) {
                answer[i][j] = midRow.remove();
            }
            answer[i][rc[0].length - 1] = end.remove();
        }
        
        return answer;
    }
}