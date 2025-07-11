

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return Integer.compare(o1, o2);
            }

            return Integer.compare(Math.abs(o1), Math.abs(o2));
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; ++i) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) {
                    sb.append(0);
                }
                else {
                    sb.append(pq.poll());
                }
                sb.append("\n");
            }
            else {
                pq.add(num);
            }
        }

        System.out.println(sb);
    }
}
