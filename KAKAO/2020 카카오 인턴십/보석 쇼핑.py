# 18, 정확성 : 13/15, 효율성 : 0/15   3:02:00~2:44:0
# set() 으로 계속 묶어서 활용하는 방식은 효율성이 매우 떨어지는 방법이라 좋지 않다.
def solution(gems: list):
    answer = []
    gems_set = set(gems)

    left = 0
    right = 0

    gems_dict = {gems[left]: 1}

    while left <= right < len(gems):
        if len(gems_dict) == len(gems_set):
            if not answer:
                answer = [left + 1, right + 1]
            else:
                pre_left, pre_right = answer[0], answer[1]
                if right - left < pre_right - pre_left:
                    answer = [left + 1, right + 1]
            prev_cnt = gems_dict.get(gems[left], 0)
            gems_dict[gems[left]] = prev_cnt - 1
            if gems_dict[gems[left]] <= 0:
                gems_dict.pop(gems[left])
            left += 1
        else:
            right += 1
            if right >= len(gems):
                break
            else:
                prev_cnt = gems_dict.get(gems[right], 0)
                gems_dict[gems[right]] = prev_cnt + 1

    return answer


# def solution(gems: list):
#     gem_types = set(gems)
#     gem_types_count = len(gem_types)
#     slice_size = gem_types_count
#
#     if len(gem_types) == len(gems):
#         return [1, len(gem_types)]
#
#     while True:
#         temp_answer = []
#         for i in range(len(gems) // 2):
#             len(gem_types)
#
#             sliced = gems[i:i + slice_size]
#             if len(set(sliced)) == gem_types_count:
#                 return [i + 1, i + slice_size]
#
#             sliced_back = gems[-slice_size - i:gem_types_count - i]
#             if len(set(sliced_back)) == gem_types_count:
#                 temp_answer = [-slice_size - i + 1, gem_types_count - i]
#         else:
#             if len(temp_answer) > 0:
#                 return temp_answer
#         slice_size += 1


# print(solution(["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]))
# print(solution(["AA", "AB", "AC", "AA", "AC"]))
# print(solution(["XYZ", "XYZ", "XYZ"]))
# print(solution(["ZZZ", "YYY", "NNNN", "YYY", "BBB"]))
# arr = []
# for i in range(50_000):
#     arr.append(str(i))
#     arr.append(str(i))
# print(solution(arr))
