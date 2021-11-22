# BFS 탐색하기

## 파란칸만 탐색하기

주어진 판에서 (0,0) 부터 시작하여, BFS를 통해 탐색하기

![image](https://user-images.githubusercontent.com/45728407/142806911-e30b01c0-b8f7-41f9-93fb-b5c2adcc57fe.png)

2차원 배열에서 BFS로 탐색할 때 `상,하,좌,우`를 탐색해야 한다.

나는 이때까지 각 방향을 메소드로 만들어서 풀었었는데, 훨씬 간단하고 직관적인 방법을 알게되었다.

`상,하,좌,우`로 이동할 수 있는 증감값을 미리 배열에 저장해두고 사용하는 방법이다.

## 풀이

```java
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solutions sol = new Solutions();

        sol.bfs();
    }
}

class Solutions {

    private int[][] board = {
            {1,1,1,0,1,0,0,0,0,0},
            {1,0,0,0,1,0,0,0,0,0},
            {1,1,1,0,1,0,0,0,0,0},
            {1,1,0,0,1,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0} };

    private int visit[][] = new int[7][10];

    public void bfs() {
        Queue<Pair> queue = new LinkedList<>();

        // index = 0:상, 1:하, 2:좌, 3:우
        int[] dy = {1,0,-1,0};
        int[] dx = {0,1,0,-1};

        Pair firstPair = new Pair(0,0);

        queue.add(firstPair);

        checkVisit(firstPair);

        while(!queue.isEmpty()) {
            Pair current = queue.poll();

            // 상하좌우 탐색
            for (int dir = 0; dir < 4; dir++) {
                Pair next = null;

                int y = current.getY() + dy[dir];
                int x = current.getX() + dx[dir];

                // 범위를 벗어난 경우
                if (y < 0 || y >= board.length || x < 0 || x >= board[0].length) continue;

                // 파란칸이 아니거나, 이미 방문했을 경우
                if (board[y][x] != 1 || visit[y][x] == 1) continue;

                next = new Pair(x, y);

                checkVisit(next);
                queue.add(next);
            }
        }
    }

    private void checkVisit(Pair pair) {
        visit[pair.getY()][pair.getX()] = 1;
        System.out.println(pair.toString());
    }

    private boolean isVisited(Pair pair) {
        return visit[pair.getY()][pair.getX()] == 1;
    }
}

class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x: " + x + ", y: " + y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
```

## 실행 결과

```
x: 0, y: 0
x: 0, y: 1
x: 1, y: 0
x: 0, y: 2
x: 2, y: 0
x: 0, y: 3
x: 1, y: 2
x: 1, y: 3
x: 2, y: 2
x: 1, y: 4
```
