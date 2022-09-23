# 20, 100/100
def calc_distance(btn1: tuple, btn2: tuple):
    return abs(btn1[0] - btn2[0]) + abs(btn1[1] - btn2[1])


def solution(numbers: list, hand: str):
    answer = ''

    default_hand = 'L' if hand == 'left' else 'R'

    keypad = {
        '1': (1, 1), '2': (2, 1), '3': (3, 1),
        '4': (1, 2), '5': (2, 2), '6': (3, 2),
        '7': (1, 3), '8': (2, 3), '9': (3, 3),
        '*': (1, 4), '0': (2, 4), '#': (3, 4),
    }

    curr_btn = {
        'L': '*',
        'R': '#'
    }

    for num in numbers:
        if num == 1 or num == 4 or num == 7:
            answer += 'L'
            curr_btn['L'] = str(num)
        elif num == 3 or num == 6 or num == 9:
            answer += 'R'
            curr_btn['R'] = str(num)
        else:
            target_btn = keypad[str(num)]
            l_cur_btn = keypad[curr_btn['L']]
            r_cur_btn = keypad[curr_btn['R']]

            l_distance = calc_distance(target_btn, l_cur_btn)
            r_distance = calc_distance(target_btn, r_cur_btn)

            if l_distance < r_distance:
                answer += 'L'
                curr_btn['L'] = str(num)
            elif l_distance > r_distance:
                answer += 'R'
                curr_btn['R'] = str(num)
            else:
                answer += default_hand
                curr_btn[default_hand] = str(num)

    return answer
