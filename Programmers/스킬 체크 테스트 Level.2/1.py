from typing import List


def solution(cacheSize: int, cities: List[str]):
    answer = 0

    cache = []

    """
    0 이상이다
        들어있다
            빼서 맨 뒤로
        안들어있다
            여유 있다 = 맨 뒤에 넣기
            여유 없다 = 맨 앞에꺼 빼고 넣기
    0 이다
    """

    for city in cities:
        if 0 == cacheSize:
            answer += 5
        else:
            city = city.lower()
            if city in cache:
                index = cache.index(city)
                popped_city = cache.pop(index)
                cache.append(popped_city)
                answer += 1
            else:
                if len(cache) < cacheSize:
                    cache.append(city)
                elif len(cache) == cacheSize:
                    cache.pop(0)
                    cache.append(city)
                answer += 5

    return answer


print(solution(3, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]))
print(solution(3, ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]))
print(solution(2, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]))
print(solution(5, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]))
print(solution(2, ["Jeju", "Pangyo", "NewYork", "newyork"]))
print(solution(0, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]))
