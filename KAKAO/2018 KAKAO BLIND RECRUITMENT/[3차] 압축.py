# 20분, 100/100
def solution(msg):
    answer = []

    dic = list('ABCDEFGHIJKLMNOPQRSTUVWXYZ')

    msglist = list(msg)

    while len(msglist) > 0:
        c = msglist.pop(0)
        i = dic.index(c) + 1

        while len(msglist) > 0:
            nc = msglist.pop(0)
            c += nc
            if c in dic:
                i = dic.index(c) + 1
            else:
                msglist.insert(0, nc)
                break

        answer.append(i)

        dic.append(c)

    return answer
