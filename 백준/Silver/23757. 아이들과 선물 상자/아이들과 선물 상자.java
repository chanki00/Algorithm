import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Queue<Integer> box = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; ++i) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        boolean isPossible = true;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; ++i) {
            int n = Integer.parseInt(st.nextToken());
            int curr = box.poll();
            if (curr < n) {
                isPossible = false;
                break;
            }

            box.add(curr - n);
        }

        int result = isPossible ? 1 : 0;
        System.out.println(result);
    }
}
