import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int t=0; t<T; ++t) {
            String op = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String[] arr = s.substring(1, s.length()-1).split(",");

            Deque<String> dq = new ArrayDeque<>();
            for (String a : arr) {
                if (a.isEmpty() || a.equals("")) {
                    continue;
                }
                dq.add(a);
            }

            boolean isPossible = true;
            boolean isFront = true;
            for (int i=0; i<op.length(); ++i) {
                if (op.charAt(i) == 'R') {
                    isFront = !isFront;
                }
                else {
                    if (dq.isEmpty()) {
                        isPossible = false;
                        break;
                    }
                    getNext(dq, isFront);
                }
            }

            if (isPossible) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");

                while(!dq.isEmpty()) {
                    sb.append(getNext(dq, isFront)).append(",");
                }

                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append("]");
                result.append(sb);
//                System.out.println(sb);
            }
            else {
//                System.out.println("error");
                result.append("error");
            }
            result.append("\n");
        }
        System.out.println(result);
    }

    public static String getNext(Deque<String> dq, boolean isFront) {
        if (isFront) {
            return dq.pollFirst();
        }
        else {
            return dq.pollLast();
        }
    }
}
