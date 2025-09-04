import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[] oper = {' ', '+', '-'};
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; ++t) {
            N = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            arr = new int[N];

            StringBuilder exp = new StringBuilder();
            for (int i=0; i<N; ++i) {
                arr[i] = i+1;
//                exp.append(arr[i]);
            }
            recursive(1, 1, 1, 1, new StringBuilder().append(1));
            System.out.println(sb);
        }
    }

    public static void recursive(int curr, int idx, int prev, int sum, StringBuilder exp) {
        if (idx == N) {
            if (sum == 0) {
                sb.append(exp).append("\n");
            }

            return;
        }

        if (exp.toString().equals("1-2")) {
            int c = 1+2;
        }

        for (int i=0; i<oper.length; ++i) {

//            exp.insert(2*idx+1, oper[i]);
            exp.append(oper[i]).append(arr[idx]);
            if (i == 0) { // 공백
                if (prev == 1) {
                    recursive(curr * 10 + arr[idx], idx + 1, prev, sum - curr + (curr * 10 + arr[idx]), exp);
                }

                if (prev == 2) {
                    recursive(curr * 10 + arr[idx], idx + 1, prev, sum + curr - (curr * 10 + arr[idx]), exp);
                }
            }
            else if (i == 1) {
                recursive(arr[idx], idx+1, 1, sum + arr[idx], exp);
            }
            else {
                recursive(arr[idx], idx+1, 2, sum - arr[idx], exp);
            }
//            exp.deleteCharAt(2*idx+1);
            exp.deleteCharAt(exp.length()-1);
            exp.deleteCharAt(exp.length()-1);
        }
    }
}
