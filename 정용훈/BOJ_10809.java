import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10809 {
    private static int[] alphas = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(alphas, -1);

        char[] S = br.readLine().toCharArray();

        for (int i = 0; i < S.length; i++) {
            int alphaPos = S[i] - 'a';
            if (alphas[alphaPos] != -1) {
                continue;
            }

            alphas[S[i] - 'a'] = i;
        }

        Arrays.stream(alphas)
                .forEach(i -> System.out.print(i + " "));
    }
}
