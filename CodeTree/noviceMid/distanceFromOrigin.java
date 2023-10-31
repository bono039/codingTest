import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int idx, x, y;

    public Point(int idx, int x, int y) {
        this.idx = idx;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        int d1 = Math.abs(this.x) + Math.abs(this.y);
        int d2 = Math.abs(p.x) + Math.abs(p.y);

        if(d1 != d2) {	// 원점에서 가까운 점부터 순서대로 출력
                return d1 - d2;
        }
        return this.idx - p.idx;	// 거리가 같은 점이 여러개면, 번호가 작은 점부터
    }
}

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	    int n = Integer.parseInt(br.readLine());
		
	    Point[] points = new Point[n];
	    for(int i = 0 ; i < n ; i++) {
	    	String[] str = br.readLine().split(" ");
	    	int x = Integer.parseInt(str[0]);
	    	int y = Integer.parseInt(str[1]);

	    	points[i] = new Point(i + 1, x, y);
	    }
		
	    Arrays.sort(points);
	    for(Point p : points) {
	    	System.out.println(p.idx);
	    }
	}
}
