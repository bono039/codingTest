import java.util.Scanner;

class Secret {
    String secret, place;
    int time;

    public Secret(String secret, String place, int time) {
        this.secret = secret; // 비밀코드
        this.place = place;   // 접선장소
        this.time = time;     // 시간
    }
};

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next(); // 비밀코드
        String b = sc.next(); // 접선장소
        int t = sc.nextInt(); // 시간

        Secret secret1 = new Secret(a, b, t);

        System.out.println("secret code : " + secret1.secret);
        System.out.println("meeting point : " + secret1.place);
        System.out.println("time : " + secret1.time);
    }
}
