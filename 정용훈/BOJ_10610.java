import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.exit;

public class BOJ_10610 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        int[] nums = new int[N.length()];

        if (!N.contains("0")) {
            System.out.println("-1");
            exit(0);
        }

        for (int i = 0; i < N.length(); i++) {
            nums[i] = Integer.parseInt(N.substring(i, i + 1));
        }

        int sum = 0;
        for (int i = 0; i < N.length(); i++) {
            sum += nums[i];
        }
        if (sum % 3 != 0) {
            System.out.println("-1");
            exit(0);
        }

        Arrays.sort(nums);
        for (int i = nums.length; i > 0; i--) {
            sb.append(nums[i - 1]);
        }
        System.out.println(sb);
    }
}
