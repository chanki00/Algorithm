import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
 
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] map;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        for (int t=1; t<=T; ++t) {
            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];
             
            int count = 1;
            int r = 0;
            int c = -1;
            int idx = 0;
             
            while (count <= N * N) {
            	int nextR = r + dr[idx];
            	int nextC = c + dc[idx];
                if (isValid(nextR, nextC, N)) {
                    r = nextR;
                    c = nextC;
                    map[r][c] = count++;
                }
                else {
                    idx = (idx+1) % 4;
                }
            }
             
             
            System.out.println("#" + t);
            for (int i=0; i<N; ++i) {
                for (int j=0; j<N; ++j) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
             
        }
    }
     
    public static boolean isValid(int r, int c, int N) {
        return r >= 0 && c >= 0 && r < N && c < N && map[r][c] == 0;
    }
}