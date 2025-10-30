import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; ++t) {
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[N+1];
            dp[0] = 1;
            for (int i=1; i<=N; ++i) {
                for (int j=1; j<=3; ++j) {
                    if (i-j >= 0) {
                        dp[i] += dp[i-j];
                    }
                }
            }

            System.out.println(dp[N]);

        }
    }
}
