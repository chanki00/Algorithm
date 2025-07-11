

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; ++i) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (pq.isEmpty()) {
//                    System.out.println(0);
                    sb.append(0).append("\n");
                }
                else {
//                    System.out.println(pq.poll());
                    sb.append(pq.poll()).append("\n");
                }
            }
            else {
                pq.add(num);
            }

        }
        System.out.println(sb);
    }
}
