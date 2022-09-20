# 18, 정확성 : 25/25, 효율성 : 0/14  2:52:00
# 65, 정확성 : 25/25, 효율성 : 0/14  2:42:00 ~ 1:37:00
def solution(stones, k):
    answer = 0

    while True:
        break_cnt = 0
        for i in range(len(stones)):
            if stones[i] > 0:
                stones[i] -= 1
                break_cnt = 0
            else:
                break_cnt += 1
                if break_cnt == k:
                    return answer
        answer += 1

    print(answer)
    return answer


solution([2, 4, 5, 3, 2, 1, 4, 2, 5, 1], 3)
solution([2, 4, 5, 3, 2, 3, 3, 3, 1, 2, 3], 3)  # 3
solution([2, 3, 2, 5, 5, 5, 5, 5, 1, 2, 1], 3)  # 3
# [0, 2, 3, 1, 0, 1, 1, 1, 0, 0, 1]

