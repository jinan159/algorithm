# 30, 100/100
def solution(s: str):
    answer = []

    s_arr = s[2:-2].split('},{')
    num_arr = [[int(i) for i in num.split(',')] for num in s_arr]

    target_len = 1

    while len(num_arr) > 0:
        sub_arr = []

        for arr in num_arr:
            if len(arr) == target_len:
                sub_arr = arr
                num_arr.remove(arr)
                break

        for num in answer:
            sub_arr.remove(num)

        answer += sub_arr
        target_len += 1

    return answer
