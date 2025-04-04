import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1. 계단은 한 번에 한 계단 또는 두 계단 씩 오를 수 있다. 2. 연속된 세 개의 계단을 모두 밟을 수 없다. (시작점은 계단에 포함
 * X) 3. 마지막 도착 계단은 반드시 밟아야 한다.
 */

public class Main {

	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N + 1];

		for (int i = 1; i <= N; ++i) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

		max = Integer.MIN_VALUE;

		int[][] memo = new int[N + 1][2];
		memo[1][0] = 0;
		memo[1][1] = stairs[1];
		if (N > 1) {
			memo[2][0] = stairs[1];
			memo[2][1] = stairs[1] + stairs[2];
		}
		for (int i = 3; i <= N; ++i) {
			memo[i][0] = Math.max(memo[i - 1][0], memo[i - 1][1]);
			memo[i][1] = Math.max(memo[i - 2][1] + stairs[i], memo[i - 3][1] + stairs[i - 1] + stairs[i]);
		}

		System.out.println(memo[N][1]);

	}

}
