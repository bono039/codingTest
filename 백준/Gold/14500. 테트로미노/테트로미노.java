import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    
    static int max = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][M];
	    
	    for(int i = 0 ; i < N ; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        for(int j = 0 ; j < M ; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
        
	    shape1();
	    shape2();
        shape3();
	    shape4();
	    shape5();
	    shape6();
	    shape7();
	    shape8();
	    shape9();
	    shape1011();
	    shape1213();
	    shape1415();
	    shape1617();
	    shape1819();
	    
	    System.out.println(max);
	}
	
	private static void shape1() {
	    for(int i = 0 ; i < N ; i++) {
	        for(int j = 0 ; j <= M - 4 ; j++) {
	            int tmp = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3];
	            max = Math.max(max, tmp);
	        }
	    }
	}

	private static void shape2() {
	    for(int i = 0 ; i <= N - 4 ; i++) {
	        for(int j = 0 ; j < M ; j++) {
	            int tmp = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j];
	            max = Math.max(max, tmp);
	        }
	    }
	}
	
	private static void shape3() {
	    for(int i = 0 ; i <= N - 2 ; i++) {
	        int tmp = 0;
	        for(int j = 0 ; j <= M - 2 ; j++) {
	            tmp = map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1];
	            max = Math.max(max, tmp);
	        }
	    }
	}
	
	private static void shape4() {
	    for(int i = 0 ; i <= N - 3 ; i++) {
	        for(int j = 0 ; j <= M - 2 ; j++) {
	            int tmp = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1];
	            max = Math.max(max, tmp);
	        }
	    }
	}
	
	private static void shape5() {
	    for(int i = 0 ; i <= N - 2 ; i++) {
	        for(int j = 0 ; j <= M - 3 ; j++) {
	            int tmp = map[i][j + 2] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
	            max = Math.max(max, tmp);
	        }
	    }
	}
	
	private static void shape6() {
	    for(int i = 0 ; i <= N - 3 ; i++) {
	        for(int j = 0 ; j <= M - 2 ; j++) {
	            int tmp = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
	            max = Math.max(max, tmp);
	        }
	    }
	}
	
	private static void shape7() {
	    for(int i = 0 ; i <= N - 2 ; i++) {
	        for(int j = 0 ; j <= M - 3 ; j++) {
	            int tmp = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j];
	            max = Math.max(max, tmp);
	        }
	    }
	}
	
	private static void shape8() {
	    for(int i = 0 ; i <= N - 3 ; i++) {
	        for(int j = 0 ; j <= M - 2 ; j++) {
	            int tmp = map[i + 2][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
	            max = Math.max(max, tmp);
	        }
	    }
	}

	private static void shape9() {
	    for(int i = 0 ; i <= N - 3 ; i++) {
	        for(int j = 0 ; j <= M - 2 ; j++) {
	            int tmp = map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 2][j];
	            max = Math.max(max, tmp);
	        }
	    }
	}

	private static void shape1011() {
	    for(int i = 0 ; i <= N - 2 ; i++) {
	        for(int j = 0 ; j <= M - 3 ; j++) {
	            int tmp1 = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 2];
	            int tmp2 = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
	            max = Math.max(max, Math.max(tmp1, tmp2));
	        }
	    }
	}

	private static void shape1213() {
	    for(int i = 0 ; i <= N - 3 ; i++) {
	        for(int j = 0 ; j <= M - 2 ; j++) {
	            int tmp1 = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
	            int tmp2 = map[i][j + 1] + map[i +1][j] + map[i + 1][j + 1] + map[i + 2][j];
	            max = Math.max(max, Math.max(tmp1, tmp2));
	        }
	    }
	}

	private static void shape1415() {
	    for(int i = 0 ; i <= N - 2 ; i++) {
	        for(int j = 0 ; j <= M - 3 ; j++) {
	            int tmp1 = map[i][j + 1] + map[i][j + 2] + map[i + 1][j] + map[i + 1][j + 1];
	            int tmp2 = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2];
	            max = Math.max(max, Math.max(tmp1, tmp2));
	        }
	    }
	}
	
	private static void shape1617() {
	    for(int i = 0 ; i <= N - 2 ; i++) {
	        for(int j = 0 ; j <= M - 3 ; j++) {
	            int tmp1 = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 1];
	            int tmp2 = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
	            max = Math.max(max, Math.max(tmp1, tmp2));
	        }
	    }
	}

	private static void shape1819() {
	    for(int i = 0 ; i <= N - 3 ; i++) {
	        for(int j = 0 ; j <= M - 2 ; j++) {
	            int tmp1 = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
	            int tmp2 = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j];
	            max = Math.max(max, Math.max(tmp1, tmp2));
	        }
	    }
	}
}
