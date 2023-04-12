import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];     // 자릿수별 배열
		int[] time = new int[n];    // 합 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < n ; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 삽입 정렬
		for(int i = 1 ; i < n ; i++) {
		    int insert_point = i;
		    int insert_value = arr[i];
		    
		    for(int j = i - 1 ; j >= 0 ; j--) {
		        // 현재 범위에서 삽입 위치 찾기
		        if(arr[i] > arr[j]) {
		            insert_point = j + 1;
		            break;
		        }
		        
		        if(j == 0) {
		            insert_point = 0;
		        }
		    }
		    
		    for(int j = i ; j > insert_point ; j--) {
		        // 삽입 위치에서 데이터를 한 칸씩 뒤로 밀기
		        arr[j] = arr[j-1];
		    }
		    // 삽입 위치에 현재 데이터 삽입
		    arr[insert_point] = insert_value;
		}
		
		// 합 배열 만들기
		time[0] = arr[0];
		for(int i = 1 ; i < n ; i++) {
		    time[i] = time[i-1] + arr[i];
		}
		
		// 합 배열 총합 계산
		int sum = 0;
		for(int i : time) {
		    sum += i;
		}
		
		System.out.println(sum);
	}
}