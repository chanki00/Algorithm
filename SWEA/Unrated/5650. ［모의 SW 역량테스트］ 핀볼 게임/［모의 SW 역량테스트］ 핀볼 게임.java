import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static int max, cnt, N;
	static int[][] map;
	static List<Point> starts;
	static Point[][] wormholes;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; ++t) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			max = 0;
			
			starts = new ArrayList<>();
			wormholes = new Point[5][2];
			
			for (int i=0; i<N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					int tmp = map[i][j];
					if (tmp == 0) {
						starts.add(new Point(i, j));
					}
					else if (tmp >= 6 && tmp <= 10) {
						if (wormholes[tmp-6][0] == null) {
							wormholes[tmp-6][0] = new Point(i, j);
						}
						else {
							wormholes[tmp-6][1] = new Point(i, j);
						}
					}
				}
			}
			
			for (Point s : starts) {
				for (int d=0; d<4; ++d) {
					int nextR = s.r;
					int nextC = s.c;
					int currD = d;
					if (!isValid(nextR, nextC)) {
						continue;
					}
					
					cnt = 0;
					
					while (true) {
						nextR += dr[currD];
						nextC += dc[currD];						
						if (!isValid(nextR, nextC)) {
							cnt = 2*cnt + 1;
							break;
						}
						
						if((nextR == s.r && nextC == s.c) || map[nextR][nextC] == -1) {
							break;
						}
						
						
						int curr = map[nextR][nextC];
						
						if (6 <= curr && curr <= 10) {
							if (nextR == wormholes[curr-6][0].r && nextC == wormholes[curr-6][0].c) {
								nextR = wormholes[curr-6][1].r;
								nextC = wormholes[curr-6][1].c;
							}
							else {
								nextR = wormholes[curr-6][0].r;
								nextC = wormholes[curr-6][0].c;
							}
						}
						
						if (curr >= 1 && curr <= 5) {
							currD = rotateDir(curr, currD);
							if (currD == 5) {
								cnt = 2*cnt + 1;
								break;
							}
							++cnt;
						}
					}
					max = Math.max(max, cnt);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(max);
			System.out.println(sb);
		}
	}
	
	public static int rotateDir(int block, int dir) { // 블록만 해당 -> 벽에 부딪히는 것도 그냥 block에 5 넘겨주면 될듯?
		if (block == 5) {
			return 5;
		}
		else if (dir == block%4) {
			return (4 + dir - 1) % 4;
		}
		else if (dir == (block+1)%4) {
			return (dir + 1) % 4;
		}
		
		return 5;
	}
	
	public static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
