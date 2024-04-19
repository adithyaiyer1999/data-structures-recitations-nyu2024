package rec_graphs;

import java.util.LinkedList;
import java.util.Queue;

public class KnightChessboard {
    private static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static class Cell {
        int x, y, dist;

        Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static boolean isValid(int x, int y, int N) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }

    public static int minKnightMoves(int N, int startX, int startY, int endX, int endY) {
        boolean[][] visited = new boolean[N][N];
        Queue<Cell> queue = new LinkedList<>();

        visited[startX][startY] = true;
        queue.add(new Cell(startX, startY, 0));

        while (!queue.isEmpty()) {
            Cell t = queue.poll();

            if (t.x == endX && t.y == endY) {
                return t.dist;
            }

            for (int i = 0; i < 8; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];

                if (isValid(x, y, N) && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Cell(x, y, t.dist + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int N = 8; // 8x8 chessboard
        int startX = 6, startY = 0; // Source
        int endX = 0, endY = 7; // Destination

        int result = minKnightMoves(N, startX, startY, endX, endY);
        System.out.println("Minimum number of steps required is " + result);
    }
}
