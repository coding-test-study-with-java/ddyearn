import java.util.Scanner;

public class 스타트링크 {
    static int f,s,g,u,d;
    static int visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        f = sc.nextInt();
        s = sc.nextInt();
        g = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        visited = new int[f+1];

        bfs(f,s,g,u,d);
    }

    static void bfs(int f, int s, int g, int u, int d) {

    }
}