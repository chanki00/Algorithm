import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r,c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		
		find(0,0,N,0);
	}
	static void find(int sr,int sc,int N,int res) {
		if(sr==r&&sc==c) {
			System.out.println(res);
			return;
		}
		int gijun=(int)Math.pow(2,N)/2;
		int nr = 0;
		int nc = 0;
		if(r<gijun+sr&&c<gijun+sc) {
			nr=sr;
			nc=sc;
		}else if(r<gijun+sr&&c>=gijun+sc) {
			nr=sr;
			nc=sc+gijun;
			res+=gijun*gijun;
		}else if(r>=gijun+sr&&c<gijun+sc) {
			nr=sr+gijun;
			nc=sc;
			res+=gijun*gijun*2;
		}else {
			nr=sr+gijun;
			nc=sc+gijun;
			res+=gijun*gijun*3;
		}
		find(nr,nc,N-1,res);
	}
}
