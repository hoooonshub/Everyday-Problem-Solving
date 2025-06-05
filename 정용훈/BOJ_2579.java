import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.exit;

public class BOJ_2579 {
    private static int[] array;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stairsCount = Integer.parseInt(br.readLine());
        array = new int[stairsCount + 1];
        dp = new int[stairsCount + 1];

        for (int i = 1; i <= stairsCount; i++) {
            int n = Integer.parseInt(br.readLine());
            array[i] = n;
        }

        dp[1] = array[1];
        if (stairsCount == 1) {
            System.out.println(dp[1]);
            exit(0);
        }

        dp[2] = dp[1] + array[2];
        if (stairsCount == 2) {
            System.out.println(dp[2]);
            exit(0);
        }

        dp[3] = Math.max(array[3] + array[1], array[3] + array[2]);
        if (stairsCount == 3) {
            System.out.println(dp[3]);
            exit(0);
        }

        for (int i = 4; i <= stairsCount; i++) {
            dp[i] = Math.max(array[i] + dp[i - 2], array[i] + array[i - 1] + dp[i - 3]);
        }

        System.out.println(dp[stairsCount]);
    }
}
