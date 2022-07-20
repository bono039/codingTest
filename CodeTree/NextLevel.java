import java.util.Scanner;

class Level {
    String id;
    int lv;

    public Level() {
        this.id = "codetree";
        this.lv = 10;
    }

    public Level(String id, int lv) {
        this.id = id;
        this.lv = lv;
    }
};

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Level user1 = new Level();


        String s = sc.next();
        int n = sc.nextInt();

        Level user2 = new Level(s, n);

        System.out.println("user " + user1.id + " lv " + user1.lv);
        System.out.println("user " + user2.id + " lv " + user2.lv);
    }
}
