import java.util.*;
import java.lang.*;
import java.io.*;


class Main {

    static int N;
    static int M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        recursive(0, new int[M], bw);

        bw.flush();
        bw.close();
    }

    public static void recursive(int idx, int[] sel, BufferedWriter bw) throws Exception {
        if (idx == sel.length) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<idx; ++i) {
                sb.append(sel[i]);
                sb.append(" ");
            }
            //System.out.println();
            bw.write(sb + "\n");
            return;
        }

        for (int i=1; i<=N; ++i) {
            sel[idx] = i;
            recursive(idx+1, sel, bw);
        }
    }
}