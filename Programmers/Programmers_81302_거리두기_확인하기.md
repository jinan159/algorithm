# 거리두기 확인하기
https://school.programmers.co.kr/learn/courses/30/lessons/81302

----

# 풀이

<details>
<summary>java</summary>

```java
class Solution {
    private final static char PEOPLE = 'P';
    private final static char PARTITION = 'X';

    private final static int[] x_move = {0,0,1,-1};
    private final static int[] y_move = {1,-1,0,0};

    private final static int[] x_cross_move = {-1,1,-1,1};
    private final static int[] y_cross_move = {-1,-1,1,1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            boolean isPlaceSafe = isPlaceSafe(place);
            answer[i] = (isPlaceSafe) ? 1 : 0;
        }
        
        return answer;
    }

    private boolean isPlaceSafe(String[] place) {
        char[][] placeMap = getPlaceMap(place);

        for (int y = 0; y < placeMap.length; y++) {
            for (int x = 0; x < placeMap[0].length; x++) {
                char chr = placeMap[y][x];
                if (chr != PEOPLE) continue;
                
                if (!isPositionSafe(placeMap, x, y)) return false;
            }
        }
        
        return true;
    }

    private boolean isPositionSafe(char[][] placeMap, int x, int y) {
        
        // 상하좌우 파티션 한칸 확인
        for (int i = 0; i < x_move.length; i++) {
            int nx = x + x_move[i];
            int ny = y + y_move[i];
            
            if (ny < 0 || ny >= placeMap.length || nx < 0 || nx >= placeMap[0].length) continue;
            
            if (placeMap[ny][nx] == PEOPLE) return false;
        }

        // 상하좌우 맨해튼 거리 2 확인
        for (int i = 0; i < x_move.length; i++) {
            int nx = x + (x_move[i] * 2);
            int ny = y + (y_move[i] * 2);

            if (ny < 0 || ny >= placeMap.length || nx < 0 || nx >= placeMap[0].length) continue;
            
            char distance2 = placeMap[ny][nx];

            nx = x + x_move[i];
            ny = y + y_move[i];

            char center = placeMap[ny][nx];
            
            if (distance2 == PEOPLE && center != PARTITION) return false;
        }
        
        // 대각선 확인
        for (int i = 0; i < x_cross_move.length; i++) {
            int nx = x + x_cross_move[i];
            int ny = y + y_cross_move[i];

            if (ny < 0 || ny >= placeMap.length || nx < 0 || nx >= placeMap[0].length) continue;

            char cross = placeMap[ny][nx];
            char near1 = placeMap[ny][x];
            char near2 = placeMap[y][nx];

            if (cross == PEOPLE && !(near1 == PARTITION && near2 == PARTITION)) return false;
        }
        
        return true;
    }

    private char[][] getPlaceMap(String[] place) {
        char[][] placeMap = new char[place.length][place[0].length()];

        for (int i = 0; i < place.length; i++) {
            placeMap[i] = place[i].toCharArray();
        }
        
        return placeMap;
    }
}
```
</details>

<details>
<summary>python</summary>

```python
PERSON = 'P'
TABLE = 'O'
PARTITION = 'X'


def isPlaceSafe(place: list):
    move_x = [0, 0, 1, -1]
    move_y = [1, -1, 0, 0]

    cross_x = [1, -1, 1, -1]
    cross_y = [1, -1, -1, 1]

    y_len = len(place)
    x_len = len(place[0])

    for y in range(y_len):
        for x in range(x_len):
            if place[y][x] != PERSON:
                continue

            for i in range(4):
                # 상하좌우 한칸
                nx = x + move_x[i]
                ny = y + move_y[i]

                if ny < 0 or ny >= y_len or nx < 0 or nx >= x_len:
                    continue

                if place[ny][nx] == PERSON:
                    return False

                # 상하좌우 두칸
                nx2 = x + (move_x[i] * 2)
                ny2 = y + (move_y[i] * 2)

                if ny2 < 0 or ny2 >= y_len or nx2 < 0 or nx2 >= x_len:
                    continue

                if place[ny2][nx2] == PERSON and place[ny][nx] != PARTITION:
                    return False

                # 대각선 확인
                nx3 = x + cross_x[i]
                ny3 = y + cross_y[i]

                if ny3 < 0 or ny3 >= y_len or nx3 < 0 or nx3 >= x_len:
                    continue

                if place[ny3][nx3] == PERSON:
                    near1 = place[ny3][x]
                    near2 = place[y][nx3]
                    if near1 != PARTITION or near2 != PARTITION:
                        return False

    return True


def solution(places: list):
    answer = []

    for place in places:
        place_list = []

        for p in place:
            place_list.append(list(p))

        if isPlaceSafe(place_list):
            answer.append(1)
        else:
            answer.append(0)

    return answer
```
</details>

----

# 결과

<details>
<summary>java</summary>
<pre class="console-content"><div></div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="91317"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.07ms, 75.6MB)</td></tr><tr data-testcase-id="91447"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.07ms, 72.9MB)</td></tr><tr data-testcase-id="91448"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.07ms, 81.4MB)</td></tr><tr data-testcase-id="91449"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.05ms, 82.8MB)</td></tr><tr data-testcase-id="91450"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.05ms, 79.2MB)</td></tr><tr data-testcase-id="91451"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.05ms, 69.5MB)</td></tr><tr data-testcase-id="91452"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.04ms, 75.5MB)</td></tr><tr data-testcase-id="91453"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.05ms, 71.8MB)</td></tr><tr data-testcase-id="91454"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.06ms, 75MB)</td></tr><tr data-testcase-id="91455"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.07ms, 82MB)</td></tr><tr data-testcase-id="91456"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.07ms, 76.4MB)</td></tr><tr data-testcase-id="91457"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.04ms, 75.6MB)</td></tr><tr data-testcase-id="91458"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.05ms, 80.7MB)</td></tr><tr data-testcase-id="91459"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.06ms, 72.7MB)</td></tr><tr data-testcase-id="91460"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (0.04ms, 73.9MB)</td></tr><tr data-testcase-id="91461"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (0.07ms, 68.1MB)</td></tr><tr data-testcase-id="91462"><td valign="top" class="td-label">테스트 17 <span>〉</span></td><td class="result passed">통과 (0.08ms, 81.5MB)</td></tr><tr data-testcase-id="91463"><td valign="top" class="td-label">테스트 18 <span>〉</span></td><td class="result passed">통과 (0.07ms, 77.6MB)</td></tr><tr data-testcase-id="91464"><td valign="top" class="td-label">테스트 19 <span>〉</span></td><td class="result passed">통과 (0.07ms, 74.8MB)</td></tr><tr data-testcase-id="91465"><td valign="top" class="td-label">테스트 20 <span>〉</span></td><td class="result passed">통과 (0.06ms, 79.8MB)</td></tr><tr data-testcase-id="91466"><td valign="top" class="td-label">테스트 21 <span>〉</span></td><td class="result passed">통과 (0.07ms, 76.1MB)</td></tr><tr data-testcase-id="91467"><td valign="top" class="td-label">테스트 22 <span>〉</span></td><td class="result passed">통과 (0.07ms, 75MB)</td></tr><tr data-testcase-id="91468"><td valign="top" class="td-label">테스트 23 <span>〉</span></td><td class="result passed">통과 (0.06ms, 72.9MB)</td></tr><tr data-testcase-id="91469"><td valign="top" class="td-label">테스트 24 <span>〉</span></td><td class="result passed">통과 (0.04ms, 80.3MB)</td></tr><tr data-testcase-id="91470"><td valign="top" class="td-label">테스트 25 <span>〉</span></td><td class="result passed">통과 (0.05ms, 71.3MB)</td></tr><tr data-testcase-id="91471"><td valign="top" class="td-label">테스트 26 <span>〉</span></td><td class="result passed">통과 (0.05ms, 72.4MB)</td></tr><tr data-testcase-id="91472"><td valign="top" class="td-label">테스트 27 <span>〉</span></td><td class="result passed">통과 (0.06ms, 75.9MB)</td></tr><tr data-testcase-id="91473"><td valign="top" class="td-label">테스트 28 <span>〉</span></td><td class="result passed">통과 (0.05ms, 78.4MB)</td></tr><tr data-testcase-id="91474"><td valign="top" class="td-label">테스트 29 <span>〉</span></td><td class="result passed">통과 (0.04ms, 77.4MB)</td></tr><tr data-testcase-id="91475"><td valign="top" class="td-label">테스트 30 <span>〉</span></td><td class="result passed">통과 (0.05ms, 76.9MB)</td></tr><tr data-testcase-id="134176"><td valign="top" class="td-label">테스트 31 <span>〉</span></td><td class="result passed">통과 (0.05ms, 74.7MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre>
</details>

<details>
<summary>python</summary>
<pre class="console-content"><div></div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="91317"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.14ms, 10.2MB)</td></tr><tr data-testcase-id="91447"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.07ms, 10.1MB)</td></tr><tr data-testcase-id="91448"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.08ms, 10.1MB)</td></tr><tr data-testcase-id="91449"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.1MB)</td></tr><tr data-testcase-id="91450"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.3MB)</td></tr><tr data-testcase-id="91451"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.07ms, 10.2MB)</td></tr><tr data-testcase-id="91452"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.06ms, 10.1MB)</td></tr><tr data-testcase-id="91453"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.05ms, 9.99MB)</td></tr><tr data-testcase-id="91454"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.3MB)</td></tr><tr data-testcase-id="91455"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.2MB)</td></tr><tr data-testcase-id="91456"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.2MB)</td></tr><tr data-testcase-id="91457"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.1MB)</td></tr><tr data-testcase-id="91458"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.4MB)</td></tr><tr data-testcase-id="91459"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.1MB)</td></tr><tr data-testcase-id="91460"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (0.05ms, 10.1MB)</td></tr><tr data-testcase-id="91461"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (0.07ms, 10.3MB)</td></tr><tr data-testcase-id="91462"><td valign="top" class="td-label">테스트 17 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.1MB)</td></tr><tr data-testcase-id="91463"><td valign="top" class="td-label">테스트 18 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.2MB)</td></tr><tr data-testcase-id="91464"><td valign="top" class="td-label">테스트 19 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.1MB)</td></tr><tr data-testcase-id="91465"><td valign="top" class="td-label">테스트 20 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.2MB)</td></tr><tr data-testcase-id="91466"><td valign="top" class="td-label">테스트 21 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.2MB)</td></tr><tr data-testcase-id="91467"><td valign="top" class="td-label">테스트 22 <span>〉</span></td><td class="result passed">통과 (0.05ms, 10.1MB)</td></tr><tr data-testcase-id="91468"><td valign="top" class="td-label">테스트 23 <span>〉</span></td><td class="result passed">통과 (0.05ms, 10.2MB)</td></tr><tr data-testcase-id="91469"><td valign="top" class="td-label">테스트 24 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.1MB)</td></tr><tr data-testcase-id="91470"><td valign="top" class="td-label">테스트 25 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10MB)</td></tr><tr data-testcase-id="91471"><td valign="top" class="td-label">테스트 26 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.1MB)</td></tr><tr data-testcase-id="91472"><td valign="top" class="td-label">테스트 27 <span>〉</span></td><td class="result passed">통과 (0.05ms, 10.2MB)</td></tr><tr data-testcase-id="91473"><td valign="top" class="td-label">테스트 28 <span>〉</span></td><td class="result passed">통과 (0.08ms, 10.1MB)</td></tr><tr data-testcase-id="91474"><td valign="top" class="td-label">테스트 29 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.4MB)</td></tr><tr data-testcase-id="91475"><td valign="top" class="td-label">테스트 30 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.2MB)</td></tr><tr data-testcase-id="134176"><td valign="top" class="td-label">테스트 31 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.1MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre>
</details>