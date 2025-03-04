import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Man{
	int r;
	int c;
	public Man(int r,int c) {
		this.r=r;
		this.c=c;
	}
}
public class Main {
	static boolean visited[][];
	static int dr[]= {-1,0,1,0};
	static int dc[]= {0,1,0,-1};
	static int N;
	static int map[][];
	static int max_nd;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		max_nd=0;
		int res=0;
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]>max_nd) max_nd=map[i][j];
			}
		}
		
		for (int nd = 0; nd <= max_nd; nd++) {
			visited=new boolean[N][N];
			int sum=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]>nd&&!visited[i][j]) {
						bfs(i,j,nd);
						sum++;
					}
					
				}
			}
			if(sum>res)res=sum;
			//print();
		}
		
		

		
		System.out.println(res);
		
	}
	
	static void bfs(int r, int c,int nd) {
		Queue<Man> q=new LinkedList<>();
		q.add(new Man(r,c));
		
		while(!q.isEmpty()) {
			Man now=q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr=now.r+dr[i];
				int nc=now.c+dc[i];
				
				if(nr>=N||nc>=N||nr<0||nc<0||visited[nr][nc]) continue;
				if(map[nr][nc]<=nd) continue;
				
				visited[nr][nc]=true;
				q.add(new Man(nr,nc));
			}
		}

		
	}
	
	
	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
