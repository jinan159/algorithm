# 30, 정확성 : 25/25, 효율성 : 14/14
# 이 문제는 시간 내 못풀어서, 해설을 보고 다시 풀어봤음
# 이분탐색을 통해 시간을 줄이는 것이 핵심
def solution(stones, k):
    left = 1
    right = max(stones)

    while left <= right:
        mid = (left + right) // 2
        cnt = 0

        for stone in stones:
            if (stone - mid) <= 0:
                cnt += 1
                if cnt >= k:
                    right = mid - 1
                    break
            else:
                cnt = 0
        else:
            left = mid + 1

    print(left)

    return left


# # 18, 정확성 : 25/25, 효율성 : 0/14  2:52:00
# # 65, 정확성 : 25/25, 효율성 : 0/14  2:42:00 ~ 1:37:00
# def solution(stones, k):
#     answer = 0
#
#     while True:
#         break_cnt = 0
#         for i in range(len(stones)):
#             if stones[i] > 0:
#                 stones[i] -= 1
#                 break_cnt = 0
#             else:
#                 break_cnt += 1
#                 if break_cnt == k:
#                     return answer
#         answer += 1
#
#     print(answer)
#     return answer


solution([2, 4, 5, 3, 2, 1, 4, 2, 5, 1], 3)
solution([1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1], 2)
