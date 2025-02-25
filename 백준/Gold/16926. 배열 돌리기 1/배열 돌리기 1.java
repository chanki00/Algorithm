import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int dr[]= {1,0,-1,0};
	static int dc[]= {0,1,0,-1};
	static int N,M,R;
	static int[][] map;
	static int[][] map2;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		map2=new int[N][M];
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				map2[i][j]=map[i][j];
			}
		}
		
		

		
		for (int k = 0; k < R; k++) {
			for (int i = 0; i < Math.min(N, M)/2; i++) {
				rotate(i,i,i);
			}
			copy();
		}
		print();

	}
	private static void rotate(int r,int c,int len) {
		int nr=len,nc=len;
		int dir=0;
		//시작 지점 임시저장
		while(true) {
			//범위 초과
			if(r+dr[dir]>=N-len||c+dc[dir]>=M-len||r+dr[dir]<len||c+dc[dir]<len) {
				dir++;
			}
			dir%=4;
//			System.out.printf("r:  %d c:   %d nr : %d nc : %d",r,c,nr,nc);
//			System.out.println();
			nr=r+dr[dir];
			nc=c+dc[dir];
			map[nr][nc]=map2[r][c];
			
			r=r+dr[dir];
			c=c+dc[dir];
			if(nr==len&&nc==len)
				break;
		}
	}
	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static void copy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map2[i][j]=map[i][j];
			}
		}
	}
}