import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] adjMat;
    static boolean[][] visited;
    static int[][] map;
    static int island_num = 2;
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    island_num++;
                }
            }
        }

        adjMat = new int[island_num][island_num];
        for (int i = 0; i < adjMat.length; i++) {
            Arrays.fill(adjMat[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] >= 2) {
                    for (int k = 0; k < 4; k++) {
                        find_I(i, j, k);
                    }
                }
            }
        }

        int[] dist = new int[island_num - 2];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] v = new boolean[island_num - 2];
        dist[0] = 0;

        for (int k = 0; k < island_num - 2; k++) {
            int minIdx = -1;
            int minD = Integer.MAX_VALUE;
            for (int i = 0; i < dist.length; i++) {
                if (!v[i] && dist[i] < minD) {
                    minIdx = i;
                    minD = dist[i];
                }
            }

            if (minIdx == -1) {
                System.out.println(-1);
                return;
            }

            v[minIdx] = true;
            for (int i = 0; i < island_num - 2; i++) {
                if (!v[i] && adjMat[minIdx][i] < Integer.MAX_VALUE) {
                    dist[i] = Math.min(dist[i], adjMat[minIdx][i]);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
                return;
            }
            result += dist[i];
        }
        System.out.println(result);
    }

    public static void find_I(int r, int c, int dir) {
        int basic = map[r][c];
        int nr = r + dr[dir];
        int nc = c + dc[dir];
        int len = 0;
        while (nr >= 0 && nc >= 0 && nr < N && nc < M) {
            if (map[nr][nc] == basic) break;
            if (map[nr][nc] >= 2) {
                if (len >= 2 && len < adjMat[basic - 2][map[nr][nc] - 2]) {
                    adjMat[basic - 2][map[nr][nc] - 2] = len;
                    adjMat[map[nr][nc] - 2][basic - 2] = len;
                }
                break;
            }
            if (map[nr][nc] == 0) len++;
            nr += dr[dir];
            nc += dc[dir];
        }
    }

    public static void dfs(int r, int c) {
        map[r][c] = island_num;
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc] && map[nr][nc] == 1) {
                dfs(nr, nc);
            }
        }
    }
}
