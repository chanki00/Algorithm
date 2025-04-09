import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int INF = 1000000001;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] graph = new int[N+1][N+1];
		for (int i=1; i<=N; ++i) {
			Arrays.fill(graph[i], INF);
			graph[i][i] = 0;
		}

		for (int i=0; i<M; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[s][e] = Math.min(graph[s][e], w);
		}
		
		for (int k=1; k<=N; ++k) {
			for (int i=1; i<=N; ++i) {
				for (int j=1; j<=N; ++j) {
					graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=N; ++i) {
			for (int j=1; j<=N; ++j) {
				if (graph[i][j] == INF) {
					graph[i][j] = 0;
				}
				sb.append(graph[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
