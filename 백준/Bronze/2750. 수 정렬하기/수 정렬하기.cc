#include <stdio.h>
#include <algorithm>
#include <functional>

using namespace std;

int main(void){
	int N;
	scanf("%d",&N);
    int A[N] = {};
	for(int i=0; i<N; i++){
		scanf("%d\n", &A[i]);
	}
	sort(A, A+N);
	
	for (int i=0; i<N; i++)
		printf("%d\n", A[i]);
		
} 