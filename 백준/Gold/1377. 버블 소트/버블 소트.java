import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		mData[] arr = new mData[N];
		
		for(int i = 0 ; i < N ; i++) {
		    arr[i] = new mData(Integer.parseInt(br.readLine()), i);
		}
		
		Arrays.sort(arr);   // O(nlogn);
		int max = 0;
		
		for(int i = 0 ; i < N ; i++) {
		    if(max < arr[i].idx - i)  // 정렬 전 idx - 정렬 후 idx
		        max = arr[i].idx - i;
		}
		System.out.println(max + 1);
	}
}

class mData implements Comparable<mData> {
    int val;
    int idx;


    public mData(int val, int idx) {
        super();
        this.val = val;
        this.idx = idx;
    }

    @Override
    public int compareTo(mData o) { // val 기준 오름차순 정렬
        return this.val - o.val;
    }
}