import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int MOD = 10007;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] memo = new int[N+1];
		memo[0] = 1;
		memo[1] = 1;
		for (int i=2; i<=N; ++i) {
			memo[i] = (memo[i-1] + 2*memo[i-2]) % MOD;
		}
		
		System.out.println(memo[N]);
	}
}
