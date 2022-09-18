# 72분, 100/100
from math import floor
from heapq import heappush


def solution(str1, str2):
    """
    1. 두 문자열을 문자열 조합으로 만들면서 배열로 만들기 and headpify
    2. 둘다 없어질 때 까지 돌면서, 교집합, 합집합 만들기
        2.0 맨 처음꺼 두개 비교 하기
        2.1 교집합 = 두개가 같을 때 넣기
        2.2 합집합 = 두개가 같을 때 넣고, 다르면 그거 하나만 더 넣고 continue 하기
    """

    heap1 = []
    heap2 = []

    for i in range(len(str1)-1):
        chr1 = str1[i]
        chr2 = str1[i+1]

        if chr1.isalpha() and chr2.isalpha():
            heappush(heap1, (chr1 + chr2).lower())

    for i in range(len(str2)-1):
        chr1 = str2[i]
        chr2 = str2[i + 1]

        if chr1.isalpha() and chr2.isalpha():
            heappush(heap2, (chr1 + chr2).lower())

    union = []
    inter = []

    NULL = '#'

    while len(heap1) > 0 or len(heap2):
        chr1 = heap1.pop(0) if len(heap1) > 0 else NULL
        chr2 = heap2.pop(0) if len(heap2) > 0 else NULL

        if chr1 == chr2:
            union.append(chr1)
            inter.append(chr1)
        else:
            if chr1 != NULL:
                union.append(chr1)
                if chr1 in heap2:
                    inter.append(chr1)
                    heap2.remove(chr1)
            if chr2 != NULL:
                union.append(chr2)
                if chr2 in heap1:
                    inter.append(chr2)
                    heap1.remove(chr2)

    if len(union) == 0:
        return 65536

    return floor((len(inter) / len(union)) * 65536)


result = solution('FRANCE', 'french')
print(result, result == 16384, end='\n\n')

result = solution('handshake', 'shake hands')
print(result, result == 65536, end='\n\n')

result = solution('aa1+aa2', 'AAAA12')
print(result, result == 43690, end='\n\n')

result = solution('E=M*C^2', 'e=m*c^2')
print(result, result == 65536, end='\n\n')

# arr = [2,3,4]
# arr.insert(0, 1)
# print(arr)