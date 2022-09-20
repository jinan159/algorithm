# 10, 100/100
from typing import List


def solution(board: List[List[int]], moves: List[int]):
    answer = 0

    EMPTY = 0

    picked = []

    for m in moves:
        x = m - 1
        for y in range(len(board)):
            target = board[y][x]

            if target == EMPTY:
                continue

            board[y][x] = EMPTY

            if len(picked) > 0:
                last_picked = picked[-1]

                if last_picked == target:
                    picked.pop()
                    answer += 2
                    break

            picked.append(target)
            break

    return answer


solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]], [1,5,3,5,1,2,1,4])
