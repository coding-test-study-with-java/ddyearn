import java.util.Scanner;

public class Robotcleaner {
    static int N, M, r, c, d;
    static int[][] arr;
    static int count = 0;
    static int back = 0;
    static int[] next = {0, 0, 0, 0};
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();
        r = scan.nextInt();
        c = scan.nextInt();
        d = scan.nextInt();

        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        clean(r, c, d);
        System.out.println(count);
    }

    public static void clean(int x, int y, int dir) {
        if (arr[x][y] == 0) {  // 현재 위치가 청소되지 않은 빈칸인 경우 청소
            arr[x][y] = -1;
            count++;
        }

        next[0] = arr[x-1][y]; // 네 방향의 모든 칸 정보 저장
        next[1] = arr[x][y+1];
        next[2] = arr[x+1][y];
        next[3] = arr[x][y-1];

        if (next[0]!=0 && next[1]!=0 && next[2]!=0 && next[3]!=0) {  // 청소되지 않은 빈칸이 없으면
            back = (dir + 2) % 4;  // 후진 방향 구하기
            if (next[back] != 1) {  // 후진할 수 있다면
                x = x + dx[back];
                y = y + dy[back];
                clean(x, y, dir);
            } else {  // 후진할 수 없다면
                return;
            }
        } else {  // 청소되지 않은 빈칸이 있으면
            dir = (dir + 3) % 4;  // 반시계방향으로 90도 회전
            if (next[dir] == 0) {  // 진행 방향의 앞칸이 청소되지 않은 빈칸이면
                x = x + dx[dir];
                y = y + dy[dir];
                clean(x, y, dir);
            } else {
                clean(x, y, dir);
            }
        }
    }
}