# 13, 100/100
from typing import List


def get_rank(matched_count):
    if matched_count == 6:
        return 1
    elif matched_count == 5:
        return 2
    elif matched_count == 4:
        return 3
    elif matched_count == 3:
        return 4
    elif matched_count == 2:
        return 5
    else:
        return 6


def solution(lottos: List[int], win_nums: List[int]):
    win_nums_set = set(win_nums)

    cnt_of_zero = 0
    matched_count = 0

    for num in lottos:
        if num == 0:
            cnt_of_zero += 1
            continue

        if num in win_nums_set:
            matched_count += 1

    min_rank = get_rank(matched_count)

    return [get_rank(cnt_of_zero + matched_count), min_rank]


solution([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19])
