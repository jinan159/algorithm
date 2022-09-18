# 40분, 100/100
def solution(m, n, board):
    answer = 0

    blank = ' '

    list_board = []

    for row in board:
        list_board.append(list(row))

    while True:
        is_in_square = [[False] * n for i in range(m)]
        no_remove_target = True
        for y in range(m - 1):
            for x in range(n - 1):
                target1 = list_board[y][x]

                if target1 == blank:
                    continue

                target2 = list_board[y][x+1]
                target3 = list_board[y+1][x]
                target4 = list_board[y+1][x+1]
                if target1 == target2 == target3 == target4:
                    no_remove_target = False
                    is_in_square[y][x] = True
                    is_in_square[y][x + 1] = True
                    is_in_square[y + 1][x] = True
                    is_in_square[y + 1][x + 1] = True

        for y in range(m):
            for x in range(n):
                if is_in_square[y][x]:
                    list_board[y][x] = blank
                    answer += 1

        for x in range(n):
            down_arr = []
            for y in range(m):
                if list_board[y][x] != blank:
                    down_arr.append(list_board[y][x])
            for ry in reversed(range(m)):
                if len(down_arr) > 0:
                    list_board[ry][x] = down_arr.pop()
                else:
                    list_board[ry][x] = blank

        if no_remove_target:
            break

    return answer