# 33분, 100/100
convert_arr = list('0123456789ABCDEF')

def convert(number: int, n: int):
    arr = []

    if number == 0:
        return ['0']

    while number > 0:
        number, mod = divmod(number, n)
        arr.append(convert_arr[mod])

    arr.reverse()
    return arr

def solution(n, t, m, p):
    answer = ''

    max_len = t * m
    all_num_arr = []
    num = 0
    while len(all_num_arr) <= max_len:
        all_num_arr += convert(num, n)
        num += 1

    for i in range(len(all_num_arr)):
        tern = i % m
        if tern == p - 1:
            answer += all_num_arr[i]
        if len(answer) == t:
            break

    return answer


print(solution(2, 4, 2, 1), "0111")
print(solution(16, 16, 2, 1), "02468ACE11111111")
print(solution(16, 16, 2, 2), "13579BDF01234567")


