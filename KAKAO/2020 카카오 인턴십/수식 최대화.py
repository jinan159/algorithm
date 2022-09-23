# 38, 100/100
from itertools import permutations


def solution(expression):
    answer = 0

    operators = []

    # 현재 포함된 연산자 추출
    for operator in ['+', '-', '*']:
        if operator in expression:
            operators.append(operator)

    expression_arr = []
    char = ''

    # 숫자와 연산자를 토큰으로 만들어 배열에 넣는다
    for c in expression:
        if c in operators:
            expression_arr.append(char)
            expression_arr.append(c)
            char = ''
        else:
            char += c
    else:
        expression_arr.append(char)

    # 연산자 우선 순위의 모든 경우의 수를 구한다
    priorities = list(permutations(operators, len(operators)))

    # 경우의 수에 따라 수식을 만든다
    for priority in priorities:

        # 연산자 우선순위에 맞게 괄호로 묶어 준다
        temp_expression_arr = expression_arr[:]
        for operator in priority:
            while operator in temp_expression_arr:
                index = temp_expression_arr.index(operator)
                n1 = temp_expression_arr[index - 1]
                o = temp_expression_arr[index]
                n2 = temp_expression_arr[index + 1]
                new = '({0}{1}{2})'.format(n1, o, n2)

                temp_expression_arr = temp_expression_arr[:index - 1] + [new] + temp_expression_arr[index + 2:]

        # 괄호 처리가 끝난 수식을 계산한다
        result = abs(eval(''.join(temp_expression_arr)))

        # 가장 큰 결과를 계속 업데이트 한다
        if answer < result:
            answer = result

    return answer