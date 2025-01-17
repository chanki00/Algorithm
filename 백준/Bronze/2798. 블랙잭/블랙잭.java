import java.util.*;
import java.lang.*;
import java.io.*;

// 재귀
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; ++i) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i=0; i<N; ++i) {
            if (cards[i] > M) {
                continue;
            }
            max = Math.max(max, recursive(cards, i+1, 1, cards[i], M));
        }

        System.out.println(max);
        
    }

    public static int recursive(int[] cards, int startIdx, int depth, int sum, int M) {
        if (depth >= 3) {
            return sum;
        }   

        int max = 0;        
        for (int i=startIdx; i<cards.length; ++i) {
            if (sum + cards[i] > M) {
                continue;
            }

            max = Math.max(max, recursive(cards, i+1, depth+1, sum + cards[i], M));
        }

        return max;
    }
}