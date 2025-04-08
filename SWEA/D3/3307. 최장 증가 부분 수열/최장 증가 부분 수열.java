import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr, tmp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int idx = 1;
			tmp = new int[N];
			tmp[0] = arr[0];
			for (int i = 1; i < N; ++i) {
				if (arr[i] > tmp[idx - 1]) {
					tmp[idx] = arr[i];
					++idx;
				} else if (arr[i] < tmp[idx - 1]) { // 들어갈 곳 찾기
					tmp[getIdx(0, idx, arr[i])] = arr[i];
				}
			}

//			System.out.println(Arrays.toString(tmp));
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(idx);
			System.out.println(sb);
		}
	}

	public static int getIdx(int lo, int hi, int val) {

		while (lo < hi) {
			int mid = (lo + hi) / 2;

			if (tmp[mid] >= val) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		return lo;
	}
}
