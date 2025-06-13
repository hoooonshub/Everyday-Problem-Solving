import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2665 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static int n;
    private static char[][] rooms;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        rooms = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                rooms[i][j] = chars[j];
            }
        }

        int result = find();
        System.out.println(result);
    }

    private static int find() {
        Queue<Room> queues = new PriorityQueue<>();

        queues.add(new Room(0, 0));
        visited[0][0] = true;

        while (!queues.isEmpty()) {
            Room current = queues.poll();

            if (current.isTarget()) {
                return current.change;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                    continue;
                }

                if (visited[nextX][nextY]) {
                    continue;
                }

                if (rooms[nextX][nextY] == '1') {
                    queues.add(new Room(nextX, nextY, current.change));
                } else {
                    queues.add(new Room(nextX, nextY, current.change + 1));
                }
                visited[nextX][nextY] = true;
            }
        }

        throw new RuntimeException("UnHandled Problem");
    }

    static class Room implements Comparable<Room> {
        int x;
        int y;
        int change;

        Room(int x, int y) {
            this.x = x;
            this.y = y;
            this.change = 0;
        }

        Room(int x, int y, int change) {
            this.x = x;
            this.y = y;
            this.change = change;
        }

        @Override
        public int compareTo(Room o) {
            return this.change - o.change;
        }

        boolean isTarget() {
            return x == n - 1 && y == n - 1;
        }
    }
}
