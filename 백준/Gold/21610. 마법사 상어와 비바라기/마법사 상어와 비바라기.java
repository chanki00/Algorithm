import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 배열은 물의 양을 의미
 * N 다음은 1, 1 이전은 N
 * (N,1), (N,2), (N-1, 1), (N-1, 2)에 비구름 생성
 * 이동 명령 M번 -> i번째 이동은 d[i]와 s[i], 8방향
 * 1. d[i] 방향으로 s[i]번 이동
 * 2. 각 구름에서 비가 내려 바구니에 물 양 +1
 * 3. 구름 사라짐
 * 4. 2번에서 증가한 칸에 물복사버그 마법 => 대각선 방향으로 거리가 1인 칸에 있는 물의 바구니의 수만큼 (r, c)에 바구니 물 양 증가
 * 4-1) 경계를 넘어가는 칸은 제외
 * 5. 물의 양이 2 이상인 칸에 구름 생성 후 물의 양 2 줄어듦 => 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 함
 * => M번 이동 끝난 후 바구니에 들어있는 물의 양의 합
 *
 */

public class Main {

    static class Cloud {
        int r;
        int c;

        public Cloud() {}
        public Cloud(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, result;
    static int[][] map;
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    static boolean[][] visited;
    static Queue<Cloud> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 0;

        map = new int[N+1][N+1];

        q =  new ArrayDeque<>();
        for (int i=1; i<=N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; ++j) {
                int v = Integer.parseInt(st.nextToken());
                map[i][j] = v;
            }
        }

        create();
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());

            createVisited();
            move(d, s);
            addWater();
            duplWater();
            removeWater();

        }

        System.out.println(result);

    }

    public static void create() {
        for (int i=N-1; i<=N; ++i) {
            for (int j=1; j<=2; ++j) {
                q.add(new Cloud(i, j));
            }
        }
    }

    public static void move(int d, int s) {
        int size = q.size();
        for (int i=0; i<size; ++i) {
            Cloud curr = q.poll();

            curr.r = (N*50 + curr.r + dr[d]*s - 1) % N + 1;
            curr.c = (N*50 + curr.c + dc[d]*s - 1) % N + 1;

            q.add(curr);
        }
    }

    public static void addWater() {
        int size = q.size();
        for (int i=0; i<size; ++i) {
            Cloud curr = q.poll();

            ++map[curr.r][curr.c];
            visited[curr.r][curr.c] = true;

            q.add(curr);
        }
    }

    public static void createVisited() {
        visited = new boolean[N+1][N+1];
    }

    public static void duplWater() {

        int size = q.size();
        for (int i=0; i<size; ++i) {
            Cloud curr = q.poll();

            int count = 0;
            for (int d=1; d<=8; d+=2) {
                int nextR = curr.r + dr[d];
                int nextC = curr.c + dc[d];

                if (isValid(nextR, nextC) && map[nextR][nextC] > 0) {
                    ++count;
                }
            }

            map[curr.r][curr.c] += count;
        }
    }

    public static void removeWater() {
        result = 0;

        for (int i=1; i<=N; ++i) {
            for (int j=1; j<=N; ++j) {
                if (map[i][j] >= 2 && !visited[i][j]) {
                    map[i][j] -= 2;
                    q.add(new Cloud(i, j));
                }
                result += map[i][j];
            }
        }
    }

    public static boolean isValid(int r, int c) {
        return r >= 1 && r <= N && c >= 1 && c <= N;
    }
}
