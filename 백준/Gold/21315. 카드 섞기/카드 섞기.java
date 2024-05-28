import java.util.*;
import java.io.*;

public class Main {
    static int N, K1, K2;
    static int[] input, deck;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    
	    input = new int[N];
	    deck = new int[N];
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i = 0 ; i < N ; i++) {
	        input[i] = Integer.parseInt(st.nextToken());
	        deck[i] = i+1;
	    }
	    
	    for(int i = 1 ; Math.pow(2, i) < N ; i++) {
	        for(int j = 1 ; Math.pow(2, j) < N ; j++) {
	            int[] arr = deck.clone();
	            
	            shuffle(i, arr);
	            shuffle(j, arr);
	            
	            boolean flag = true;
	            for(int k = 0 ; k < N ; k++) {
	                if(arr[k] != input[k]) {
	                    flag = false;
	                    break;
	                }
	            }
	            
	            if(flag) {
	                K1 = i;
	                K2 = j;
	                break;
	            }
	        }
	    }
	    
	    System.out.println(K1 + " " + K2);
	}
	
	private static void shuffle(int k, int[] arr) {
	    int range = N;
	    int cnt = 0;
	    
	    for(int i = 1 ; i <= k+1 ; i++) {
	        cnt = (int)Math.pow(2, k-i+1);
	        swap(range, cnt, arr);
	        range = cnt;
	    }
	}
	
	private static void swap(int range, int cnt, int[] arr) {
	    List<Integer> tmp = new ArrayList<>();
	    
	    for(int i = range-cnt ; i < range ; i++) {
	        tmp.add(arr[i]);
	        arr[i] = 0;
	    }
	    
	    for(int i = 0 ; i < range ; i++) {
	        if(arr[i] != 0) {
	            tmp.add(arr[i]);
	        }
	        arr[i] = tmp.get(i);
	    }
	}
}
