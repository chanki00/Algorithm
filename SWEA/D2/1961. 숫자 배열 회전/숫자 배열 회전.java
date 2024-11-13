import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] matrix;
	static int[][] matrix_c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; ++t) {
			
			int N = Integer.parseInt(br.readLine());
			matrix = new int[N][N];
			
			for (int i=0; i<N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; ++j) {
					int num = Integer.parseInt(st.nextToken());
					matrix[i][j] = num;
				}
			}
			
			System.out.println("#" + t);
			
			for (int i=0; i<N; ++i) {
				for (int j=N-1; j>=0; --j) {
					System.out.print(matrix[j][i]);
				}
				System.out.print(" ");
				
				for (int j=N-1; j>=0; --j) {
					System.out.print(matrix[N-1-i][j]);
				}
				System.out.print(" ");
				
				for (int j=0; j<N; ++j) {
					System.out.print(matrix[j][N-1-i]);
				}
				System.out.println();
			}
			
		}
	}

}
