import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());   // 신호등 개수
		int L = Integer.parseInt(st.nextToken());   // 도로 길이
		
		int position = 0;   // 현재 위치
		int time = 0;       // 시간 변수
		
		while(N --> 0) {
		    st = new StringTokenizer(br.readLine(), " ");
		    
		    int D = Integer.parseInt(st.nextToken());   // 신호등 위치
		    int R = Integer.parseInt(st.nextToken());   // 빨간색
		    int G = Integer.parseInt(st.nextToken());   // 초록색
		    
		    time += D - position;   // 시간 += 신호등 위치 - 현재 위치
		    position = D;           // 현재 위치를 D로 재설정
		    
		    int gap = time % (R + G);   // 시간을 (빨간불 + 파란불) 한 사이클로 나눠 나머지를 gap에 저장
		    if(gap < R) time += R - gap;    // 아직 빨간불을 기다리는 중이므로 빨간불이 남은 시간만큼 더함
		}
		
		time += L - position;   // 도로 끝 - 현재 위치를 시간에 더함
		
		System.out.println(time);
	}
}
