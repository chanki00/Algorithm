import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 20363
 *
 * X만큼의 온기, Y만큼의 수분 -> 당근
 * 햇빛 1번 -> 온기 1 증가 / 햇빛 10번 -> 수분 1 감소 (0이면 감소 X)
 * 물 1번 -> 수분 1 증가 / 물 10번 -> 온기 1 감소
 * 맨 처음 온기 수분 = 0
 * 당근이 되는 햇빛, 물 횟수 합의 최솟값은?
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());

        System.out.println(findMin(X, Y));

    }

    public static long findMin(long X, long Y) {
        long warmCount = 0;
        long waterCount = 0;
        if (X > Y) {
            warmCount = X + Y / 10;
            waterCount = Y;
        }

        else {
            waterCount = Y + X / 10;
            warmCount = X;
        }

        return warmCount + waterCount;

    }
}
