# 91, 100/100
# 아래 풀이에서 itertools 를 사용한 것이 병목으로 의심되었음
# 그래서 이를 재귀로 구하도록 변경하여 시간 복잡도를 줄이는 데 성공함
from typing import List, AnyStr

STAR = '*'


def compareWithStar(str1: str, str2: str):
    if len(str1) != len(str2):
        return False

    for i in range(len(str1)):
        c1 = str1[i]
        c2 = str2[i]

        if c1 == STAR or c2 == STAR:
            continue

        if c1 != c2:
            return False

    return True


def search(ban_list: List[List[AnyStr]], combi: list, ban_set: set, curr: int, cnt: int):
    bans = ban_list[curr]
    for ban in bans:
        copy = ban_set.copy()
        if ban in copy:
            continue

        copy.add(ban)

        if curr + 1 == len(ban_list):
            combi.append(list(copy))
        else:
            search(ban_list, combi, copy, curr + 1, cnt)


def solution(user_id: List[AnyStr], banned_id: List[AnyStr]):
    ban_list = [[] for i in range(len(banned_id))]

    for i in range(len(banned_id)):
        ban = banned_id[i]

        for user in user_id:
            if compareWithStar(ban, user):
                ban_list[i].append(user)

    if len(ban_list) == 0:
        return 0

    combinations = list()
    ban_set = set()

    search(ban_list, combinations, ban_set, 0, 0)

    temp = []

    for combination in combinations:
        if len(combination) == len(set(combination)):
            temp_arr = list(combination)
            temp_arr.sort()
            if temp_arr not in temp:
                temp.append(temp_arr)

    return len(temp)


"""
# 55, 90.9/100
# 이 풀이는 조합을 itertools 를 이용해서 풀어서 시간초과가 났음

from typing import List, AnyStr
from heapq import heapify
from itertools import product

STAR = '*'


def compareWithStar(str1: str, str2: str):
    if len(str1) != len(str2):
        return False

    for i in range(len(str1)):
        c1 = str1[i]
        c2 = str2[i]

        if c1 == STAR or c2 == STAR:
            continue

        if c1 != c2:
            return False

    return True


def solution(user_id: List[AnyStr], banned_id: List[AnyStr]):
    ban_list = [[] for i in range(len(banned_id))]

    for i in range(len(banned_id)):
        ban = banned_id[i]

        for user in user_id:
            if compareWithStar(ban, user):
                ban_list[i].append(user)

    combinations = set(product(*ban_list))

    temp = []

    for combi in combinations:
        if len(combi) == len(set(combi)):
            temp_arr = list(combi)
            temp_arr.sort()
            if temp_arr not in temp:
                temp.append(temp_arr)

    return len(temp)

"""