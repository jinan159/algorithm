# 20분, 100/100
def solution(n: int, arr1: list, arr2: list):
    answer = []

    for i in range(n):
        row = bin(arr1[i] | arr2[i]).replace('0b', '').zfill(n)
        answer.append(row.replace('1', '#').replace('0', ' '))

    return answer
