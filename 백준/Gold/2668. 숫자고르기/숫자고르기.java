import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static Queue<Integer> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visited = new boolean[N+1];
        pq = new PriorityQueue<>();

        for (int i=1; i<=N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i=1; i<=N; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, i);
                visited[i] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append("\n");
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int idx, int start) {
        int next = arr[idx];

        if (!visited[next]) {
            visited[next] = true;
            dfs(next, start);
            visited[next] = false;
        }
        else if (next == start) {
            pq.add(start);
        }
    }
}
