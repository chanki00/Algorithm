import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class Main {
	
	static class Man{
		int r;
		int c;
		int bit;
		int len;
		public Man(int r, int c, int bit, int len) {
			this.r = r;
			this.c = c;
			this.bit = bit;
			this.len = len;
		}
	}
	static int res;
	static int N,M;
	static char map[][];
	static boolean[][][] v;
	static int dr[]= {-1,0,1,0};
	static int dc[]= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		res=-1;
		map=new char[N][M];
		v=new boolean[N][M][1<<6];
		int gor=0,goc=0;
		for (int i = 0; i < N; i++) {
			String str=br.readLine();
			for (int j = 0; j < str.length(); j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='0') {
					gor=i;
					goc=j;
				}
			}
		}
		bfs(gor,goc);
		System.out.println(res);
	}
	static void bfs(int gor,int goc) {
		Man fman=new Man(gor,goc,0,0);
		Queue<Man> q=new LinkedList<>();
		q.add(fman);
		v[gor][goc][0]=true;
		while(!q.isEmpty()) {
			Man now=q.poll();
			if(map[now.r][now.c]=='1') {
				res=now.len;
				break;
			}
			
//			System.out.printf("nr : %d nc : %d key : %d \n",now.r,now.c,now.bit);
			for (int i = 0; i < 4; i++) {
				int nr=now.r+dr[i];
				int nc=now.c+dc[i];
				int nk=now.bit;
				if(nr>=N||nr<0||nc>=M||nc<0||map[nr][nc]=='#')continue;
				if(v[nr][nc][now.bit]) continue;
				//열쇠 발견
				if(map[nr][nc]>='a'&&map[nr][nc]<='f') {
					nk=now.bit|(1<<map[nr][nc]-'a'-0);
					//문 발견
				}else if(map[nr][nc]>='A'&&map[nr][nc]<='F') {
					//열쇠 유무 판단
					//열쇠 없음
					if((now.bit&(1<<(map[nr][nc]-'A')))==0) {
						continue;
					}
				}
				//문 발견, 열쇠 있음, .,
				v[nr][nc][nk]=true;
				q.add(new Man(nr,nc,nk,now.len+1));
			}
		}
	}
}
