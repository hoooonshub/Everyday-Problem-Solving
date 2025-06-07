import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1085 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int xDis;
        if (Math.abs(x) > Math.abs(x - w)) {
            xDis = Math.abs(x - w);
        } else {
            xDis = Math.abs(x);
        }

        int yDis;
        if (Math.abs(y) > Math.abs(y - h)) {
            yDis = Math.abs(y - h);
        } else {
            yDis = Math.abs(y);
        }

        System.out.println(Math.min(xDis, yDis));
    }
}
