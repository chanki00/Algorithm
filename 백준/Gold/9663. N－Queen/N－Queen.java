import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N, count;
	static int[][] map;
	static boolean[][] possible;

	static int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = 0;

		map = new int[N][N];
		possible = new boolean[N][N];

		bt(0, 0, 0);

		System.out.println(count);
	}

	public static void bt(int r, int c, int queenCount) {

		if (queenCount == N) {
			++count;
			return;
		}

		if (r == N || c == N) {
			return;
		}

		if (map[r][c] == 0) {
			// 해당 위치에 퀸 놓음
			fill(r, c, 1);
			bt(r + 1, 0, queenCount + 1);
			fill(r, c, -1);

		}
		
		// 해당 위치에 퀸 안 놓음
		bt(r, c+1, queenCount);
	}

	// flag가 1이면 채우기 -1이면 비우기
	public static void fill(int r, int c, int flag) {
		for (int d = 0; d < 8; ++d) {
			int nextR = r;
			int nextC = c;
			while (isValid(nextR, nextC)) {
				map[nextR][nextC] += flag;
				nextR += dr[d];
				nextC += dc[d];
			}
		}
	}

	public static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
