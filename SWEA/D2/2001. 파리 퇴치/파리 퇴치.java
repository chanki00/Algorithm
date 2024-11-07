import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			for (int i=0; i<N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#" + t + " " + killFly(map,M));
			
			
		}
		
	}
	
	public static int killFly(int[][] map, int M) {
		int max = Integer.MIN_VALUE;
		
		for (int i=0; i<=map.length-M; ++i) {
			int count = 0;
			for (int x=i; x<i+M; ++x) {
				for (int y=0; y<M; ++y) {
					count += map[x][y];
				}
			}
			
			if (max < count ) {
				max = count;
			}
			
			for (int j=1; j<=map[0].length-M; ++j) {
				for (int k=i; k<i+M; ++k) {
					count -= map[k][j-1];
					count += map[k][j-1+M];
				}
				if (max < count) {
					max = count;
				}
			}
		}
		
		
		return max;
	}

}
