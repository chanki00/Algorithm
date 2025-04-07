import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Job {
		int t;
		int p;
		
		Job(int t, int p) {
			this.t =  t;
			this.p = p;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Job[] arr = new Job[N+1];
		int[] memo = new int[N+1];
		
		for (int i=1; i<=N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int profit = Integer.parseInt(st.nextToken());
			
			arr[i] = new Job(time, profit);
		}

		for (int i=1; i<=N; ++i) {
			if (i+arr[i].t-1 <= N) {			
				memo[i+arr[i].t-1] = Math.max(memo[i+arr[i].t-1], memo[i-1] + arr[i].p);
			}
			memo[i] = Math.max(memo[i], memo[i-1]);
		}
		
//		System.out.println(Arrays.toString(memo));
		System.out.println(memo[N]);
	}
}
