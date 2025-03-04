import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N,num;
	static int[] arr;
	static int res[]=new int[3];
	static int res_max;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		num=Integer.parseInt(st.nextToken());
		arr=new int[N];
		res_max=0;
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		cal(0,0);
		System.out.println(res_max);
		
	}
	static void cal(int idx,int i) {
		if(idx==3) {
			int sum=0;
			for (int j = 0; j < 3; j++) {
				sum+=res[j];
			}
			if(sum<=num) {
				res_max=Math.max(sum, res_max);
			}
			return;
		}
		if(i==N) {
			return;
		}
		
		
		res[idx]=arr[i];
		cal(idx+1,i+1);
		cal(idx,i+1);
		
	}

}
