import java.util.Scanner;

public class Main {

    public static void printOne(int n) {
        if(n==0)
            return;
        
        printOne(n-1);
        System.out.print(n + " ");
    }

    public static void printTwo(int n) {
        if(n==0)
            return;
        
        System.out.print(n + " ");
        printTwo(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        printOne(n);
        System.out.println();
        printTwo(n);
    }
}
