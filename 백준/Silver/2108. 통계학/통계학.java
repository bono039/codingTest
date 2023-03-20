import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    var br = new BufferedReader(new InputStreamReader(System.in));
	    //Scanner sc = new Scanner(System.in);
	    
	    int n = Integer.parseInt(br.readLine());
	    int[] list = new int[n];   
	    
	    for(int i=0 ; i < n ; i++) {
	        list[i] = Integer.parseInt(br.readLine());
	    }
	    
	    Arrays.sort(list); 
	    
	    // 산술평균
	    double sum = 0;
	    for(int i : list) {
	        sum += i;
	    }
	    double result = Math.round(sum / n);
	    System.out.println((int)Math.ceil(result));
	    
	    // 중앙값
	    int mid = list[list.length/2];
	    System.out.println(mid);
	    
	    // 최빈값 - 카운팅 정렬
        int[] cnt = new int[8001];
        int max = 0;
        for(int i=0 ; i < list.length ; i++) {
            cnt[list[i] + 4000]++;
            max = Math.max(cnt[list[i] + 4000], max);
        }
        
        ArrayList<Integer> max_idx = new ArrayList<>();
        
        for(int i=0 ; i <= 8000 ; i++) {
            if(max == cnt[i])
                max_idx.add(i-4000);
        }
        int how = (max_idx.size() > 1) ? max_idx.get(1) : max_idx.get(0);
        System.out.println(how);
        
        // 범위
        int range = list[n-1] - list[0];
        System.out.println(range);
	}
}