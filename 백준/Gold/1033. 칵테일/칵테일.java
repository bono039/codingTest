import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<cNode>[] A;    // 인접 리스트
    static long lcm;                // 최소공배수
    static boolean visited[];       // 탐색 여부 저장 배열
    static long D[];                // 각 노드값 저장 배열
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        A = new ArrayList[N];       // 인접 리스트
        visited = new boolean[N];   // 탐색 여부 저장 배열
        D = new long[N];            // 각 노드값 저장 배열
        lcm = 1;                    // 최소공배수
        
        for(int i = 0 ; i < N ; i++) {
            A[i] = new ArrayList<cNode>();
        }
        
        for(int i = 0 ; i < N - 1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            
            // 인접 리스트 배열에 엣지 정보 저장
            A[a].add(new cNode(b, p, q));
            A[b].add(new cNode(a, q, p));
            
            // 최소공배수 업데이트 (두 수의 곱 / 최대공약수)
            lcm *= (p * q / gcd(p, q)); 
        }
        
        D[0] = lcm; // 0번 노드에 최소공배수 저장
        DFS(0);     // 0번에서 DFS 수행
        
        // 업데이트된 D 배열 값들의 최대 공약수 계산
        long mgcd = D[0];
        for(int i = 1 ; i < N ; i++) {
            mgcd = gcd(mgcd, D[i]);
        }
        for(int i = 0 ; i < N ; i++) {
            System.out.print(D[i] / mgcd + " ");
        }
    }
    
    
    // 최대공약수 함수
    public static long gcd(long a, long b) {
        if(b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    
    // DFS (탐색 함수)
    public static void DFS(int Node) {
        visited[Node] = true;
        
        for(cNode i : A[Node]) {
            int next = i.getB();
            
            if(!visited[next]) {
                D[next] = D[Node] * i.getQ() / i.getP();    // 다음 노드 값 = 현재 노드 값 * 비율
                DFS(next);
            }
        }   
    }
}


// 노드 클래스 선언
class cNode {
    int b;
    int p;
    int q;
    
    public cNode(int b, int p, int q) {
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }
    
    public int getB() {return b;}
    public int getP() {return p;}
    public int getQ() {return q;}
}
