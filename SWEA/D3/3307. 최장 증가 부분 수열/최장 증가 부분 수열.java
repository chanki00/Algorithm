import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {

			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int[] memo = new int[N];
			memo[0] = 1;
			for (int i = 1; i < N; ++i) {
				int maxMemo = 0;
				for (int j = 0; j < i; ++j) {
					if (arr[j] < arr[i]) {
						if (memo[j] > maxMemo) {
							maxMemo = memo[j];
						}
					}
				}
				memo[i] = maxMemo + 1;
			}

//		System.out.println(Arrays.toString(memo));
			Arrays.sort(memo);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(memo[N-1]);
			System.out.println(sb);
		}
	}
}
