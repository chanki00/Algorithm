import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int l = Integer.MIN_VALUE;
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
            l = Math.max(l, arr[i]);
        }

        int r = 1000000000;

        int result = parametric(l, r);

        System.out.println(result);
    }

    public static int parametric(int l, int r) {
        while (l < r) {
            int mid = l + (r-l)/2;

            if (check(mid)) {
                r = mid;
            }
            else {
                l = mid+1;
            }
        }

        return l;
    }

    public static boolean check(int mid) {
        int cnt = 0;
        int curr = 0;
        for (int i=0; i<N; ++i) {
            if (curr < arr[i]) {
                curr = mid;
                ++cnt;
            }

            curr -= arr[i];
        }

        return cnt <= M;
    }
}
