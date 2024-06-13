import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] count = new int[M+1][N+1];

            System.out.println(combination(M, N, count));
        }

        br.close();
    }

    public static int combination(int n, int r, int[][] count) {
        if (n == r || r == 0) count[n][r] = 1;
        if (count[n][r] != 0) return count[n][r];
        count[n][r] = combination(n-1, r-1, count) + combination(n-1, r, count);

        return count[n][r];
    }
}