# 60분, 90/100
def solution(cacheSize: int, cities: list):
    answer = 0

    cache = []

    for c in cities:
        city = str(c).lower()
        if city in cache:
            cache.remove(city)
            cache.append(city)
            answer += 1
        else:
            if len(cache) >= cacheSize > 0:
                cache.pop(0)
            cache.append(city)
            answer += 5

    return answer

# + 5분, 100/100, cacheSize 가 0 인데도 캐시를 넣어줘서 그랬음;;;
# 1번째 풀이가 캐시 사이즈가 0인데도 append 하고있음;;; 이 무슨 멍청한 짓인지..
def solution(cacheSize: int, cities: list):
    answer = 0

    cache = []

    for c in cities:
        city = str(c).lower()
        if city in cache:
            cache.remove(city)
            cache.append(city)
            answer += 1
        else:
            if cacheSize > 0:
                if len(cache) >= cacheSize:
                    cache.pop(0)
                cache.append(city)
            answer += 5

    return answer