import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] students, recommend, time;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

	    N = Integer.parseInt(br.readLine());   // 사진 틀 수
	    M = Integer.parseInt(br.readLine());  // 추천 횟수
	    
	    List<Info> list = new ArrayList<>();
	    List<Integer> ans = new ArrayList<>();
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0 ; i < M ; i++) {
	        int student = Integer.parseInt(st.nextToken());
	        
	        if(list.size() < N) {
	            boolean flag = false;
	            
	            for(Info info : list) {
	                if(info.num == student) {
	                    info.cnt++;
	                    flag = true;
	                    break;
	                }
	            }
	            
	            if(!flag)
	                list.add(new Info(i, student, 1));
	        }
	        else {
	            Collections.sort(list);
	            boolean flag = false;
	            
	            for(Info info : list) {
                    if(info.num == student) {
                        info.cnt++;
                        flag = true;
                        break;
                    }
	            }
	            
	            if(!flag) {
	                list.remove(0);
	                list.add(new Info(i, student, 1));
	            }
	        }
	    }
	    
	    // print
	    for(Info i : list) {
	        ans.add(i.num);
	    }
	    Collections.sort(ans);
	    
	    for(int i : ans) {
	        System.out.print(i + " ");
	    }
	    System.out.println();
	}
	
	static class Info implements Comparable<Info> {
        int idx, num, cnt;
        
        public Info(int idx, int num, int cnt) {
            this.idx = idx;
            this.num = num;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Info info) {
            if(this.cnt == info.cnt)
                return this.idx - info.idx;
            return this.cnt - info.cnt;
        }
    }
}
