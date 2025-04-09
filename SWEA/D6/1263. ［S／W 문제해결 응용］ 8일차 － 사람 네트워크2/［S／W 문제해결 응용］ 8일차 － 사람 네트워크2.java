import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int INF = 10000000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] graph = new int[N+1][N+1];
			
			for (int i=1; i<=N; ++i) {
				for (int j=1; j<=N; ++j) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					if (graph[i][j] == 0 && i != j) {
						graph[i][j] = INF;
					}
				}
			}
			
			for (int k=1; k<=N; ++k) {
				for (int i=1; i<=N; ++i) {
					for (int j=1; j<=N; ++j) {
						graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
					}
				}
			}
			
			int min = INF;
			for (int i=1; i<=N; ++i) {
				int cc = 0;
				for (int j=1; j<=N; ++j) {
					cc += graph[i][j];
				}
				min = Math.min(min, cc);
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(min);
			System.out.println(sb);
		}
	}
}
