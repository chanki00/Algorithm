import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static class Point {
		int r;
		int c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, H, W, min;
	static int[][] map;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;

			map = new int[H][W];

			int block = 0;
			for (int i = 0; i < H; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 0) {
						++block;
					}
				}
			}

			recursive(0, map, block);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(min);
			System.out.println(sb);
		}
	}

	public static void recursive(int cnt, int[][] inMap, int block) {
		if (cnt == N) {
			min = Math.min(min, block);
			return;
		}

		for (int i = 0; i < W; ++i) {
			int[][] tmp = copyMap(inMap);
			int gap = bomb(i, tmp);			
			recursive(cnt + 1, tmp, block - gap);
		}
	}

	public static int bomb(int col, int[][] tmp) {
		int row = 0;
		for (row = 0; row < H; ++row) {
			if (tmp[row][col] != 0) {
				break;
			}
		}

		if (row == H || tmp[row][col] == 0) {
			return 0;
		}

		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(row, col));
		int chk = 0;
		boolean[][] visited = new boolean[H][W];

		while (!q.isEmpty()) {
			Point curr = q.poll();
			int c = tmp[curr.r][curr.c];
			tmp[curr.r][curr.c] = 0;
//			--chk;
			++chk;

			for (int d = 0; d < 4; ++d) {
				int cnt = 1;
				int nextR = curr.r;
				int nextC = curr.c;
				while (cnt < c) {
					nextR += dr[d];
					nextC += dc[d];
					++cnt;
					if (!isValid(nextR, nextC)) {
						break;
					}

					if (visited[nextR][nextC]) {
						continue;
					}

					visited[nextR][nextC] = true;
					if (tmp[nextR][nextC] > 1) {
						q.add(new Point(nextR, nextC));
					} else if (tmp[nextR][nextC] == 1) {
						tmp[nextR][nextC] = 0;
//						--chk;
						++chk;
					}
				}
			}
		}

		down(tmp);
		return chk;
	}

	public static void down(int[][] tmp) {
		int zeroIdx = -1;
		int idx = -1;

		for (int k = 0; k < W; ++k) {
			int i = H - 1;
			int j = H - 1;
			while (i >= 0 && j >= 0) { // i위치가 0이고 j가 0이 아니면 j를 i로 옮긴다.
				while (i >= 0 && tmp[i][k] != 0) {
					--i;
				}
				while (j >= i || (j >= 0 && tmp[j][k] == 0)) {
					--j;
				}
				if (i >= 0 && j >= 0 && tmp[i][k] == 0 && tmp[j][k] != 0) {
					tmp[i][k] = tmp[j][k];
					tmp[j][k] = 0;
					--i;
					--j;
				}
			}
		}
	}

	public static int[][] copyMap(int[][] in) {
		int[][] ret = new int[H][W];
		for (int i = 0; i < H; ++i) {
			for (int j = 0; j < W; ++j) {
				ret[i][j] = in[i][j];
			}
		}

		return ret;
	}

	public static boolean isValid(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}
}
