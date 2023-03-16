#include <stdio.h>

int sum(int a, int b){
	return a+b;
}

int main(void){
	int A, B;
	scanf("%d %d", &A, &B);
	printf("%d", sum(A,B));
	
	return 0;
}