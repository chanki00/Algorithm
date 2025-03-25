import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][N];
        long[][] S = new long[N+1][N+1];
        for (int i=0; i<N; ++i) {
            A[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j=0; j<N; ++j) {
                S[i+1][j+1] = S[i][j+1] + S[i+1][j] - S[i][j] + A[i][j];
            }
        }

        for (int t=0; t<M; ++t) {
            int[] idx = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long result = S[idx[2]][idx[3]] - S[idx[2]][idx[1]-1] - S[idx[0]-1][idx[3]] + S[idx[0]-1][idx[1]-1];
            System.out.println(result);
        }
    }
}
