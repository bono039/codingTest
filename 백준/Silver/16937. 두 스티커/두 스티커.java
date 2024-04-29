import java.util.*;
import java.io.*;

public class Main {
    static int H,W,N;
    static List<Sticker> list = new ArrayList<>();
    static int answer = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    H = Integer.parseInt(st.nextToken());
	    W = Integer.parseInt(st.nextToken());
	    
	    N = Integer.parseInt(br.readLine());
	    
	    while(N --> 0) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int r = Integer.parseInt(st.nextToken());
	        int c = Integer.parseInt(st.nextToken());
	        
	        if((r > H && r > W) || (c > W && c > H))    continue;
	        list.add(new Sticker(r, c));
	    }
	    
	    solve();
	    System.out.println(answer);
	}
	
	private static void solve() {
	    for(int i = 0 ; i < list.size() ; i++) {
	        Sticker now = list.get(i);
	        int size = now.r * now.c;
	        
	        int tmpR = H - now.r;
	        int tmpC = W - now.c;
	        
	        if(tmpR >= 0 && tmpC >= 0)
	            second(i, tmpR, tmpC, size);

	        tmpR = H - now.c;
	        tmpC = W - now.r;
	        if(tmpR >= 0 && tmpC >= 0)
	            second(i, tmpR, tmpC, size);
	    }
	}
	
	private static void second(int idx, int rr, int cc, int size) {
	    int secondSize = 0;
	    
	    for(int i = idx + 1 ; i < list.size() ; i++) {
	        Sticker now = list.get(i);
	        
	        int tmpSize = now.r * now.c;
	        
	        if((now.r <= rr && now.c <= W) || (now.r <= H && now.c <= cc)
	            || (now.c <= rr && now.r <= W) || (now.c <= H && now.r <= cc))
	            secondSize = Math.max(secondSize, tmpSize);
	    }
	    
	    if(secondSize != 0)
	        answer = Math.max(answer, size + secondSize);
	}
}

class Sticker {
    int r, c;
    
    public Sticker(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
