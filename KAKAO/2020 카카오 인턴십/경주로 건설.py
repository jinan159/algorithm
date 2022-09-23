# 30분 2:34:00 ~ 1:54:00
def isCorner(prev: list, corner: list, next: list):
    prev_x, prev_y = prev[0], prev[1]
    c_x, c_y = corner[0], corner[1]
    next_x, next_y = next[0], next[1]

    # p2 가 코너
    if (prev_x == c_x and next_y == c_y) or (prev_y == c_y and next_x == c_x):
        return True

    return False


def solution(board: list[list[int]]):
    answer = 0

    x_move = [0, 0, 1, -1]
    y_move = [-1, 1, 0, 0]

    start = [0, 0]
    stack = [start]

    path = []

    cost = [[0] * len(board[0])] * len(board)
    cost[0][0] == 100

    while len(stack) > 0:
        isAfterCorner
        if len(stack) >= 3:
            prev_path = stack[-3:]


        curr = stack.pop()

        path.append(curr)

        if len(path) >= 3:
            if len(path) > 3:
                path.pop(0)
            if isCorner(path[0], path[1], path[0]):
                pass
        else:
            if len(path) == 2:
                px, py = path[0][0], path[0][1]
                x, y = curr[0], curr[1]
                pre_cost = cost[py][px]
                cost[y][x] = pre_cost + 100

        for i in range(4):
            nx = curr[0] + x_move[i]
            ny = curr[1] + y_move[i]

            if nx < 0 or nx >= len(board[0]) or ny < 0 or ny >= len(board):
                continue


            stack.append()


    return answer


print(solution([[0,0,0],[0,0,0],[0,0,0]]), ', ', 900)
print(solution([[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0],[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,0],[0,0,0,1,0,0,0,1],[0,0,1,0,0,0,1,0],[0,1,0,0,0,1,0,0],[1,0,0,0,0,0,0,0]]), ', ', 3800)
print(solution([[0,0,1,0],[0,0,0,0],[0,1,0,1],[1,0,0,0]]), ', ', 2100)
print(solution([[0,0,0,0,0,0],[0,1,1,1,1,0],[0,0,1,0,0,0],[1,0,0,1,0,1],[0,1,0,0,0,1],[0,0,0,0,0,0]]), ', ', 3200)


