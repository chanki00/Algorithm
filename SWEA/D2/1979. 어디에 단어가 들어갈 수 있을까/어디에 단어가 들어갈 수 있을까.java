import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] map;
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int total = 0;

			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (map[i][j] == 1) {
						if (j == 0 || map[i][j - 1] == 0) {
							total += findRow(i, j);
						}

						if (i == 0 || map[i - 1][j] == 0) {
							total += findCol(i, j);
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + total);
		}

	}

	public static int findRow(int r, int c) {
		int length = 0;
		while (c < N && map[r][c] == 1) {
			++length;
			++c;
		}
		
		return length == K ? 1 : 0;
	}

	public static int findCol(int r, int c) {
		int length = 0;
		
		while (r < N && map[r][c] == 1) {
			++length;
			++r;
		}
		
		return length == K ? 1 : 0;
	}

}
