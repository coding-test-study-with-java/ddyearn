import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 수
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            // 스티커의 개수
            int n = sc.nextInt();

            int[][] stickers = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= n; j++) {
                    stickers[i][j] = sc.nextInt();
                }
            }
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];
            for (int k = 2; k <= n; k++) {
                dp[0][k] = Math.max(dp[1][k - 1], dp[1][k - 2]) + stickers[0][k];
                dp[1][k] = Math.max(dp[0][k - 1], dp[0][k - 2]) + stickers[1][k];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}