# 46분, 45.5/100
from typing import List, AnyStr


def solution(words: List[AnyStr]):
    answer = 0

    """
    1. 오름차순 정렬
    2. 맨 앞에꺼 선택해서,
    """

    words.sort()

    for i in range(len(words)):
        word = words[i]

        for j in range(1, len(word)+1):
            keyword = word[0:j]

            if keyword == word:
                answer += len(keyword)
                break

            if i == 0:
                compare = words[1]
                if compare.find(keyword) >= 0:
                    continue
            elif i == len(words) - 1:
                compare = words[i-1]
                if compare.find(keyword) >= 0:
                    continue
            else:
                compare1 = words[i-1]
                compare2 = words[i+1]
                if compare1.find(keyword) >= 0 or compare2.find(keyword) >= 0:
                    continue

            answer += len(keyword)
            break

    return answer
