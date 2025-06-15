import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2156 {
    private static int[] wines;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        wines = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
            dp[i] = -1;
        }

        dp[0] = wines[0];
        if (n >= 2) {
            dp[1] = wines[1] + dp[0];
        }
        if (n >= 3) {
            dp[2] = Math.max(wines[2] + Math.max(wines[0], wines[1]), dp[1]);
        }

        for (int i = 3; i < n; i++) {
            dp[i] = wines[i] + Math.max(wines[i - 1] + dp[i - 3], dp[i - 2]);
            dp[i] = Math.max(dp[i], dp[i - 1]); // 안 마시는 경우 직전 최대 값 그대로 가져오기
        }

        Arrays.stream(dp)
                .max()
                .ifPresent(System.out::println);
    }
}
