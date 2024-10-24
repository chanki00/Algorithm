import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class VirusPoint {
        int pointI;
        int pointJ;
        int original;

        public VirusPoint(int pointI, int pointJ) {
            this.pointI = pointI;
            this.pointJ = pointJ;
        }

        public VirusPoint(int pointI, int pointJ, int original) {
            this.pointI = pointI;
            this.pointJ = pointJ;
            this.original = original;
        }
    }

    static List<VirusPoint> points = new ArrayList<>();
    static int[][] unit = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static List<Integer> timeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (map[i][j] == 2) {
                    points.add(0, new VirusPoint(i, j, map[i][j]));
                    map[i][j] = -1;
                    putVirus(map, i, 1, M);
                    map[points.get(0).pointI][points.get(0).pointJ] = points.get(0).original;
                    points.remove(0);
                }
            }
        }

        System.out.println(findMinTime());


    }

    public static void putVirus(int[][] map, int idxI, int count, int M) {
        if (count == M) {
            spreadVirus(map, 0, M, 0);
            return;
        }

        for (int i = idxI; i < map.length; ++i) {
            for (int j = 0; j < map[0].length; ++j) {
                if (map[i][j] == 2) {
                    points.add(count, new VirusPoint(i, j, map[i][j]));
                    map[i][j] = -1;
                    putVirus(map, i, count + 1, M);
                    map[points.get(count).pointI][points.get(count).pointJ] = points.get(count).original;
                    points.remove(count);
                }
            }
        }
    }

    public static void spreadVirus(int[][] map, int time, int M, int prevCount) {
        if (isFullMap(map)) {
            timeList.add(time);
            removePoints(map, M);
            return;
        }

        if (points.size() == prevCount) {
            return;
        }

        List<VirusPoint> tmpList = new ArrayList<>();

        for (VirusPoint p : points) {
            for (int i = 0; i < unit.length; ++i) {
                int idxI = p.pointI + unit[i][0];
                int idxJ = p.pointJ + unit[i][1];
                if (isValid(map, idxI, idxJ)) {
                    tmpList.add(new VirusPoint(idxI, idxJ, map[idxI][idxJ]));
                    map[idxI][idxJ] = -1;
                }
            }
        }
        ++time;

        int currSize = points.size();

        points.addAll(tmpList);

        spreadVirus(map, time, M, currSize);
        removePoints(map, M);

    }

    public static boolean isFullMap(int[][] map) {
        for (int i=0; i<map.length; ++i) {
            for (int j=0; j<map[0].length; ++j) {
                if (!(map[i][j] == 1 || map[i][j] == -1)) return false;
            }
        }

        return true;
    }

    public static void removePoints(int[][] map, int M) {
        if (points.size() <= M) return;

        while (points.size() > M) {
            VirusPoint p = points.get(points.size()-1);
            map[p.pointI][p.pointJ] = p.original;
            points.remove(points.size()-1);
        }
    }

    public static int findMinTime() {
        int minTime = Integer.MAX_VALUE;
        if (timeList.isEmpty()) return -1;

        for (int t : timeList) {
            if (t < minTime) {
                minTime = t;
            }
        }

        return minTime;
    }

    public static boolean isValid(int[][] map, int i, int j) {
        return i >= 0 && j >= 0 && i < map.length && j < map[0].length && (map[i][j] != 1 && map[i][j] != -1);
    }
}

