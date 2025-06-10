import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1453 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[] guests = new boolean[101];
        int answer = 0;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            int guest = Integer.parseInt(st.nextToken());

            if (guests[guest]) {
                answer++;
            } else {
                guests[guest] = true;
            }
        }

        System.out.println(answer);
    }
}
