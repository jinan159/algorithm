# 47분, 100/100
from math import floor


def addMinutes(time: str, minutes: int):
    arr = time.split(':')
    h = int(arr[0])
    m = int(arr[1])

    h += floor(minutes / 60)
    m += minutes % 60

    if m >= 60:
        h += floor(m / 60)
        m -= 60

    if h >= 24:
        h -= 24
    elif h < 0:
        h += 24

    return str(h).zfill(2) + ':' + str(m).zfill(2)


def solution(n: int, t: int, m: int, timetable: list):
    numer_of_trip = n
    term = t
    max_capacity = m

    trip_time = '09:00'

    """
    1. timetable 정렬
    2. 마지막 회차만 남을 때 까지 timetable 비우기
    3. 마지학 회차가 남으면 콘이 탈 수 있는 시간 중 가장 늦은 시간을 찾는다
        1) m == 1
            timetable[0] - 1
    """

    timetable.sort()

    for i in range(numer_of_trip - 1):
        for j in range(max_capacity):
            if timetable[0] <= trip_time:
                timetable.pop(0)
        trip_time = addMinutes(trip_time, term)

    for i in range(max_capacity-1):
        if len(timetable) > 0:
            timetable.pop(0)

    if len(timetable) > 0:
        con_time = addMinutes(timetable[0], -1)

        if con_time < trip_time:
            return con_time

    return trip_time
