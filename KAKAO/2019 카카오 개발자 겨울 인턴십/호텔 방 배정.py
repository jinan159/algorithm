# 추가 풀이 2
# 30, 정확성 : 26/26, 효율성 : 7/7
# 클래스를 써서 느린거였다;;; 로직에는 문제가 없엇음....
def solution(k: int, room_number: list):
    answer = []

    room_map = dict()

    for room in room_number:
        next_room = room_map.get(room, 0)
        if next_room == 0:
            answer.append(room)
            room_map[room] = room + 1
        else:
            visited = [room]
            while True:
                cur_room = next_room
                next_room = room_map.get(next_room, 0)
                if next_room == 0:
                    answer.append(cur_room)
                    room_map[cur_room] = cur_room + 1
                    for v in visited:
                        room_map[v] = cur_room + 1
                    break
                visited.append(next_room)

    return answer


arr = solution(10, [1, 3, 1, 1, 1])
print(arr)


# 추가 풀이 2
# 10, 정확성 : 26/26, 효율성 : 2/7
# class Room:
#     def __init__(self, _no, _next):
#         self.no = _no
#         self.isReserved = False
#         self.next_no = _next
#
#
# def solution(k, room_number):
#     answer = []
#
#     rooms = [Room(i, i+1) for i in range(0, k + 1)]
#     rooms[-1].next_no = None
#
#     for num in room_number:
#         target_room = rooms[num]
#
#         if target_room.isReserved:
#             visited = []
#             next_room = rooms[target_room.next_no]
#             while next_room.isReserved:
#                 visited.append(next_room.no)
#                 next_room = rooms[next_room.next_no]
#             next_room.isReserved = True
#             answer.append(next_room.no)
#
#             for v in visited:
#                 rooms[v].next_no = next_room.next_no
#
#             target_room.next_no = next_room.next_no
#         else:
#             target_room.isReserved = True
#             answer.append(target_room.no)
#
#     return answer


# 추가 풀이 1
# 10, 정확성 : 26/26, 효율성 : 0/7
# def solution(k, room_number):
#     answer = []
#
#     room_reserved = [False for i in range(k + 1)]
#
#     for num in room_number:
#         for i in range(num, len(room_reserved)):
#             if not room_reserved[i]:
#                 room_reserved[i] = True
#                 answer.append(i)
#                 break
#
#     return answer


# 10, 정확성 : 25/26, 효율성 : 0/7 2:42:00
# def solution(k, room_number):
#     answer = []
#
#     room_info_list = [[i + 1, True] for i in range(k)]
#
#     for num in room_number:
#         for i in range(num, k):
#             room_info = room_info_list[i - 1]
#             if room_info[1]:
#                 room_info_list[i - 1][1] = False
#                 answer.append(room_info_list[i - 1][0])
#                 break
#
#     return answer
