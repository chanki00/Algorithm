import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cakeList = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; ++i) {
            cakeList[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(cakeList));
    }

    public static int solve(int[] cakeList) {
        double sum = 0;
        int count = 0;

        for (int i=0; i<cakeList.length; ++i) {
            count += recursiveSolve(cakeList, sum + getInverse(cakeList[i]), i+1);
        }

        return count;
    }

    public static int recursiveSolve(int[] cakeList, double sum, int idx) {
        if (sum > 1.01) return 0;
        if (sum >= 0.99 && sum <= 1.01) return 1;
        if (idx == cakeList.length) return 0;

        int count = 0;

        for (int i=idx; i<cakeList.length; ++i) {
            count += recursiveSolve(cakeList, sum + getInverse(cakeList[i]), i+1);
        }

        return count;
    }

    public static double getInverse(int num) {
        return (1.0 / num);
    }
}