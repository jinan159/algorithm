# 33 + 30, 100/100
"""
2시간 안에 제출 못하고 30분 초과...
중위 순획 문제로 생각해서 괜히 어렵게 풀다가 머리 터져서 못풀었는데
그냥 단순하게 상하위 부모만 있으면 for 문 돌려서 찾으면 되는거였음ㅋㅋ
"""
class Node:
    def __init__(self, _name, _parent):
        self.name = _name
        self.money = 0
        self.parent = _parent
        self.child = []

    def __str__(self):
        return self.name

    def setMoney(self, money):
        if self.parent is not None and money > 0:
            parent_money = int(money / 10)
            self.money += money - parent_money
            self.parent.setMoney(parent_money)
        else:
            self.money += money

def solution(enroll, referral, seller, amount):
    answer = []

    mem_dict = {'-': Node('-', None)}

    seller_map = {}
    for i in range(len(seller)):
        seller_map[seller[i]] = amount[i]

    # enroll 로 모두 mem_dict 에 등록
    for i in range(len(enroll)):
        e = enroll[i]
        r = referral[i]
        mem_dict[e] = Node(e, mem_dict[r])
        mem_dict[r].child.append(mem_dict[e])

    for i in range(len(seller)):
        seller_name = seller[i]
        total_amount = amount[i] * 100
        mem_dict[seller_name].setMoney(total_amount)

    for e in enroll:
        answer.append(mem_dict[e].money)

    return answer
