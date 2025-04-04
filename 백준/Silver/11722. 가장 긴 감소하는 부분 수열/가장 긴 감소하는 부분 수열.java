import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i=0; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 1;
		int maxIdx = 0;
		
		int[] memo = new int[N];
		memo[0] = 1;
		for (int i=1; i<N; ++i) {
			int cnt = 0;
			int maxMemo = 0;
			for (int j=0; j<i; ++j) {
				if (arr[j] > arr[i]) {
					if (memo[j] > maxMemo) {
						maxMemo = memo[j];
					}
				}
			}
			memo[i] = maxMemo + 1;
		}
		
//		System.out.println(Arrays.toString(memo));
		Arrays.sort(memo);
		System.out.println(memo[N-1]);
	}
}
