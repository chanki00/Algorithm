import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] result = new int[M];

        count = 0;

        for (int i=0; i<N; ++i) {
            arr[i] = i+1;
        }

        findSequence(arr, N, M, 0, result);

    }

    public static void findSequence(int[] arr, int n, int m, int idx, int[] result) {
        ++count;
        if (count > m) {
            String str = Arrays.toString(result).replaceAll("[^1-9 ]", "");
            System.out.println(str);
            --count;
            return;
        }

        for (int i=idx; i<n; ++i) {
            result[count-1] = arr[i];
            findSequence(arr, n, m, i+1, result);
        }
        --count;
    }
}
