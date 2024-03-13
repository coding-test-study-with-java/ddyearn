import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int temp[][] = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            temp[i][0] = Integer.parseInt(st.nextToken());
            temp[i][1] = Integer.parseInt(st.nextToken());
            temp[i][2] = Integer.parseInt(st.nextToken());
        }

        int res = 0;

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if (i == j || j == k || i == k)
                        continue;

                    String std = "" + i + j + k;
                    boolean flag = true;

                    //// 조건 만족하는지 체크
                    for (int tc = 0; tc < N; tc++) {

                        int cntS = 0;
                        int cntB = 0;
                        String tempStr = String.valueOf(temp[tc][0]);

                        // 자릿수 비교
                        for (int l = 0; l < 3; l++) {
                            if (std.charAt(l) == tempStr.charAt(l)) {
                                cntS++;
                            } else if (std.contains(tempStr.charAt(l) + "")) {
                                cntB++;
                            }
                        }

                        //검증
                        if (cntS != temp[tc][1] || cntB != temp[tc][2]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag)
                        res++;
                }
            }
        }
        System.out.println(res);
    }
}