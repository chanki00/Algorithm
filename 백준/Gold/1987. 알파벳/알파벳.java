import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] unit = {
			{1, 0}, {-1,0}, {0, 1}, {0, -1}
	};
	
	static int max = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		for (int i=0;i<R; ++i) {
			map[i] = br.readLine().toCharArray();
		}
		
		boolean[] visited = new boolean[26];
		int currR = 0;
		int currC = 0;
	
		visited[map[currR][currC] - 65] = true;

		solve(map, visited, 0, 0, max);
		
		System.out.println(max);
	}
	
	public static void solve(char[][] map, boolean[] visited, int currR, int currC, int depth) {

		max = Math.max(max,  depth);
		
		for (int i=0; i<4; ++i) {
			int nextR = currR + unit[i][0];
			int nextC = currC + unit[i][1];
			
			if (isValid(map, visited, nextR, nextC)) {
				visited[map[nextR][nextC] - 65] = true;
				solve(map, visited, nextR, nextC, depth + 1);
				visited[map[nextR][nextC] - 65] = false;
			}
		}
		
	}
	
	public static boolean isValid(char[][] map, boolean[] visited, int r, int c) {
		return r >= 0 && c >= 0 && r < map.length && c < map[0].length && !visited[map[r][c]-65];
	}

}
