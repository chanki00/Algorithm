import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	static class Product {
		int w;
		int v;

		Product(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			Product[] arr = new Product[N + 1];
			for (int i = 1; i <= N; ++i) {
				st = new StringTokenizer(br.readLine());
				int w = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				arr[i] = new Product(w, v);
			}

			int[] memo = new int[K + 1];
			for (int i = 1; i <= N; ++i) {
				for (int w = K; w - arr[i].w >= 0; --w) {
					memo[w] = Math.max(memo[w], memo[w - arr[i].w] + arr[i].v);
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(memo[K]);
			System.out.println(sb);
		}
	}
}
