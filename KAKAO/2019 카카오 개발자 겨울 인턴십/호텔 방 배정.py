# 10, 정확성 : 25/26, 효율성 : 0/7 2:42:00
def solution(k, room_number):
    answer = []

    room_info_list = [[i + 1, True] for i in range(k)]

    for num in room_number:
        for i in range(num, k):
            room_info = room_info_list[i - 1]
            if room_info[1]:
                room_info_list[i - 1][1] = False
                answer.append(room_info_list[i - 1][0])
                break

    """
     1
        2
      3
       4
         5
          6
    7
    8
    9
    10
    
    
    1
    3
    4
    1
    3
    1
    """

    return answer
