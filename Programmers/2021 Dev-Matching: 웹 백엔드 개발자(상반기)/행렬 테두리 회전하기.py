# 69, 100/100
from typing import List

LEFT = 'LEFT'
RIGHT = 'RIGHT'
UP = 'UP'
DOWN = 'DOWN'


def getDirection(s_y, s_x, e_y, e_x, py, px):

    if s_x <= px < e_x and py == s_y:
        return RIGHT
    elif s_x < px <= e_x and py == e_y:
        return LEFT
    elif s_y < py <= e_y and px == s_x:
        return UP
    elif s_y <= py < e_y and px == e_x:
        return DOWN

    return None


def rotate_map(num_map: List[List[int]], query: List[int]):
    min_num = 99999

    s_y, s_x, e_y, e_x = query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1

    new_map = [item[:] for item in num_map]

    # UP
    for y in range(s_y + 1, e_y + 1):
        target_num = num_map[y][s_x]
        min_num = target_num if target_num < min_num else min_num
        new_map[y - 1][s_x] = target_num
    # Down
    for y in range(s_y, e_y):
        target_num = num_map[y][e_x]
        min_num = target_num if target_num < min_num else min_num
        new_map[y+1][e_x] = target_num
    # LEFT
    for x in range(s_x + 1, e_x + 1):
        target_num = num_map[e_y][x]
        min_num = target_num if target_num < min_num else min_num
        new_map[e_y][x-1] = target_num
    # RIGHT
    for x in range(s_x, e_x):
        target_num = num_map[s_y][x]
        min_num = target_num if target_num < min_num else min_num
        new_map[s_y][x+1] = target_num

    return new_map, min_num


def solution(rows: int, columns: int, queries: List[List[int]]):
    answer = []

    num_map = []

    for i in range(rows):
        row = []
        for j in range(columns):
            x = j + 1
            row.append(x + (i * columns))
        num_map.append(row)

    for query in queries:
        num_map, min_num = rotate_map(num_map, query)
        answer.append(min_num)

    return answer
