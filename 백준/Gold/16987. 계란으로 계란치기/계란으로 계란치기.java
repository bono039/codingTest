import java.util.*;

public class Main {
	static int n,max=Integer.MIN_VALUE;
	static int[] durability, weight;
    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		durability=new int[n];
		weight=new int[n];
		

		for(int i=0;i<n;i++) {
			durability[i]=sc.nextInt();
			weight[i]=sc.nextInt();
		}
		
		backtracking(0);
		System.out.println(max);
	}
	
	static void backtracking(int depth) {
		// 마지막 계란인 경우
		if(depth==n) {
			int count=0;

			for(int i=0;i<n;i++) 
				if(durability[i]<=0)
					count++;
			
			max=Math.max(max, count);
			return;
		}
        
		if(durability[depth]<=0)
			backtracking(depth+1);
		
		else {
			boolean broken=false;
            
			for(int i=0;i<n;i++) {
				if(i==depth||durability[i]<=0)
					continue;
                
				broken=true;
				durability[i]-=weight[depth];
				durability[depth]-=weight[i];
                
				backtracking(depth+1);
                
				durability[i]+=weight[depth];
				durability[depth]+=weight[i];
			}
            
			if(broken==false)
				backtracking(depth+1);
		}
	}
}