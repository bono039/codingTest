import java.util.*;
// 가장 큰 양의 정수 a의 값
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {        
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        // arrA에서 최대공약수 구하고, arrB 내 원소들 나눠지는지 구하기
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        // arrB에서 최대공약수 구하고, arrA 내 원소들 나눠지는지 구하기
        for(int i = 1 ; i < arrayA.length ; i++) {
            gcdA = gcd(arrayA[i], gcdA);
            gcdB = gcd(arrayB[i], gcdB);
        }
        
        if(!canDivide(arrayB, gcdA)) {
            answer = Math.max(answer, gcdA);
        }
        
        if(!canDivide(arrayA, gcdB)) {
            answer = Math.max(answer, gcdB);
        }
        
        return answer;
    }
    
    // 약수 구하기 (유클리드 호제법)
    private static int gcd(int a, int b) {
        if(b == 0)  return a;
        return gcd(b, a % b);
    }
    
    private static boolean canDivide(int[] arr, int gcd) {
        for(int i : arr) {
            if(i % gcd == 0)
                return true;
        }
        return false;
    }
}