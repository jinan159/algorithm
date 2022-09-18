# 60분, 66.7/100
from typing import List, AnyStr
from datetime import timedelta


def minusminutes(time1: str, time2: str):
    if time1 < time2:
        time1, time2 = time2, time1

    arr1 = time1.split(':')
    arr2 = time2.split(':')

    h1, m1 = arr1[0], arr1[1]
    h2, m2 = arr2[0], arr2[1]

    diff = timedelta(hours=int(h1), minutes=int(m1)) - timedelta(hours=int(h2), minutes=int(m2))

    return int(diff.seconds / 60)


def solution(m: str, musicinfos: List[AnyStr]):
    answer = ''

    """
    1. 전체 음악을 만든다
        1.1 시간 빼기 시간 해서 분을 만든다
        1.2 분만큼 음악을 늘린다.
        1.3 한칸씩 이동하면서 들은만큼 잘라서 비교한다
    """

    m_list = list(m)

    while '#' in m_list:
        i = m_list.index('#')
        m_list[i - 1] += '#'
        m_list.pop(i)

    title_and_melody = []

    for music in musicinfos:
        arr = music.split(',')
        minutes = minusminutes(arr[0], arr[1])
        title = arr[2]
        melody = list(arr[3])

        while '#' in melody:
            i = melody.index('#')
            melody[i - 1] += '#'
            melody.pop(i)

        if minutes >= len(melody):
            melody = melody * int(minutes / len(melody))
            minutes %= len(melody)

        melody += melody[0:minutes]

        title_and_melody.append((title, melody))

    m_len = len(m_list)

    for nam in title_and_melody:
        title = nam[0]
        melody = nam[1]

        for i in range(len(melody) - m_len):
            if melody[i:i+m_len] == m_list:
                return title

    return '(None)'


print(solution("CC#BCC#BCC#BCC#B", ["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]))
from typing import List, AnyStr
from datetime import timedelta


def minusminutes(time1: str, time2: str):
    if time1 < time2:
        time1, time2 = time2, time1

    arr1 = time1.split(':')
    arr2 = time2.split(':')

    h1, m1 = arr1[0], arr1[1]
    h2, m2 = arr2[0], arr2[1]

    diff = timedelta(hours=int(h1), minutes=int(m1)) - timedelta(hours=int(h2), minutes=int(m2))

    return int(diff.seconds / 60)


def solution(m: str, musicinfos: List[AnyStr]):
    answer = ''

    """
    1. 전체 음악을 만든다
        1.1 시간 빼기 시간 해서 분을 만든다
        1.2 분만큼 음악을 늘린다.
        1.3 한칸씩 이동하면서 들은만큼 잘라서 비교한다
    """

    m_list = list(m)

    while '#' in m_list:
        i = m_list.index('#')
        m_list[i - 1] += '#'
        m_list.pop(i)

    title_and_melody = []

    for music in musicinfos:
        arr = music.split(',')
        minutes = minusminutes(arr[0], arr[1])
        title = arr[2]
        melody = list(arr[3])

        while '#' in melody:
            i = melody.index('#')
            melody[i - 1] += '#'
            melody.pop(i)

        if minutes >= len(melody):
            melody = melody * int(minutes / len(melody))
            minutes %= len(melody)

        melody += melody[0:minutes]

        title_and_melody.append((title, melody))

    m_len = len(m_list)

    for nam in title_and_melody:
        title = nam[0]
        melody = nam[1]

        for i in range(len(melody) - m_len):
            if melody[i:i+m_len] == m_list:
                return title

    return '(None)'


print(solution("CC#BCC#BCC#BCC#B", ["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]))
