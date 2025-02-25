import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int fresh_r[];
	static int result;
	static int dr[]= {-1,0,1,0};
	static int dc[]= {0,1,0,-1};
	static int dr2[]= {1,0,-1,0};
	static int dc2[]= {0,1,0,-1};
	static int R,C,T;
	static int[][] map;
	static int[][] map2;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		fresh_r=new int[2];
		map=new int[R][C];
		map2=new int[R][C];
		for (int i = 0; i < R; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for (int t = 0; t < T; t++) {
			int cnt=0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j]==-1){
						fresh_r[cnt]=i;
						cnt++;
					}
					if(map[i][j]>=1)
						dust(i,j);
				}
			}

			//공기청정기 배치
			map2[fresh_r[0]][0]=-1;
			map2[fresh_r[1]][0]=-1;
			
			clean_up(fresh_r[0],0);
			clean_down(fresh_r[1],0);

			result=cal();
			
			copy();
			map2=new int[R][C];
		}
		System.out.println(result);

	}
	static void clean_down(int r,int c) {
		int dir=0;
		int nr=0,nc=0;
		while(true) {
			if(nr==fresh_r[1]&&nc==0) break;
			if(r+dr2[dir]<fresh_r[1]||c+dc2[dir]>=C||r+dr2[dir]>=R||c+dc2[dir]<0) {
				dir++;
			}
			dir%=4;
			nr=r+dr2[dir];
			nc=c+dc2[dir];
			
			map2[r][c]=map2[nr][nc];
			
			r=r+dr2[dir];
			c=c+dc2[dir];
			
		}
		map2[fresh_r[1]][1]=0;
		map2[fresh_r[1]][0]=-1;
	}
	static void clean_up(int r,int c) {
		int dir=0;
		int nr=0,nc=0;
		while(true) {
			if(nr==fresh_r[0]&&nc==0) break;
			if(r+dr[dir]>fresh_r[0]||c+dc[dir]>=C||r+dr[dir]<0||c+dc[dir]<0) {
				dir++;
			}
			dir%=4;
			nr=r+dr[dir];
			nc=c+dc[dir];
			
			map2[r][c]=map2[nr][nc];
			
			r=r+dr[dir];
			c=c+dc[dir];
			
		}
		map2[fresh_r[0]][1]=0;
		map2[fresh_r[0]][0]=-1;
	}
	
	static void dust(int r,int c) {
		int cnt=0;
		for (int i = 0; i < 4; i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			//범위 초과 및 공기청정기 존재
			if(nr<0||nc<0||nr>=R||nc>=C||map[nr][nc]==-1) continue;
			
			map2[nr][nc]+=map[r][c]/5;
			cnt++;
		}
		map2[r][c]+=map[r][c]-(map[r][c]/5)*cnt;
	}
	
	
	
	static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void copy() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j]=map2[i][j];
			}
		}
	}
	
	static int cal() {
		int tmp=0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map2[i][j]<=0) continue;
				tmp+=map2[i][j];
			}
		}
		return tmp;
	}
}