import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_7568 {

    public static void main(String[] args) throws IOException {
        List<Person> people = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            people.add(new Person(Integer.parseInt(st.nextToken()),
                                    Integer.parseInt(st.nextToken())));
        }

        for (Person me : people) {
            for (Person other : people) {
                if (me == other) {
                    continue;
                }

                if (other.isBigger(me)) {
                    me.plusBig();
                }
            }
        }

        for (Person p : people) {
            bw.write((p.biggerThanMe + 1) + " ");
        }

        bw.flush();
        bw.close();
    }

    static class Person {
        int weight;
        int height;
        int biggerThanMe;

        Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
            this.biggerThanMe = 0;
        }

        boolean isBigger(Person other) {
            return this.weight > other.weight && this.height > other.height;
        }

        void plusBig() {
            this.biggerThanMe++;
        }
    }
}
