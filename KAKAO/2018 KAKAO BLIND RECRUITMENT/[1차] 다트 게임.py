# 20분 + 10분, 제출 못함
def solution(dartResult: str):
    score = [0, 0, 0]
    score_index = 0

    for c in dartResult:
        if c.isnumeric():
            num = int(c)

        elif c.isalpha():
            if c == 'S':
                score[score_index] = num ** 1
            elif c == 'D':
                score[score_index] = num ** 2
            elif c == 'T':
                score[score_index] = num ** 3
            score_index += 1
        elif c == '*':
            score[score_index - 1] *= 2
            if score_index > 1:
                score[score_index - 2] *= 2
        elif c == '#':
            score[score_index - 1] *= -1

    return score[0] + score[1] + score[2]


# 15분, 100/100
# 각 항목을 token 으로 잘 만드는게 중요
# 특히, 10을 잘 골라내는게 중요함
def solution(dartResult: str):

    tokens = []

    for c in dartResult:
        if c.isnumeric() and len(tokens) > 0 and tokens[-1].isnumeric():
            tokens[-1] += c
        else:
            tokens.append(c)

    scores = []

    for t in tokens:
        if t.isnumeric():
            num = int(t)
        elif t.isalpha():
            if t == 'S':
                scores.append(num ** 1)
            elif t == 'D':
                scores.append(num ** 2)
            elif t == 'T':
                scores.append(num ** 3)
        elif t == '*':

            if len(scores) > 1:
                scores[-2] *= 2
            scores[-1] *= 2
        elif t == '#':
            scores[-1] *= -1

    return scores[0] + scores[1] + scores[2]


print(solution('1D2S#10S'))