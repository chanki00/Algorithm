import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 25496
 * 만들 수 있는 장신구 수 = N / 장신구를 만들면 Ai만큼의 피로도 누적
 * 피로도가 200 미만인 경우 장신구 제작 가능
 * 현재 피로도가 P일 때 임스가 제작할 수 있는 장신구의 최대 개수는?
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] items = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(items);

        int count = 0;
        for (int i = 0; i < N; ++i) {
            if (P >= 200) break;
            ++count;
            P += items[i];
        }

        System.out.println(count);

    }


}
