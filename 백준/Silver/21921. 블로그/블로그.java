import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i=0; i<X; ++i) {
            sum += arr[i];
        }


        Map<Integer, Integer> map = new HashMap<>();
        map.put(sum, 1);
        for (int i=0; i<N-X; ++i) {
            sum -= arr[i];
            sum += arr[i+X];
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        int max = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            max = Math.max(max, key);
        }
        int cnt = map.get(max);

        if (max <= 0) {
            System.out.println("SAD");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(cnt);
        System.out.println(sb);

    }
}
