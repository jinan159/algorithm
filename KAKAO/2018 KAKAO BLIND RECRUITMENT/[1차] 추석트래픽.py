# 40분, 제출 못함
from typing import List, AnyStr
from datetime import datetime, timedelta


def solution(lines: List[AnyStr]):
    answer = 0

    start_end_times = []

    for l in lines:
        datetime_units = l.split(' ')
        date = datetime_units[0]
        time = datetime_units[1]
        processing_time = datetime_units[2]

        end = datetime.fromisoformat(date + ' ' + time)

        if '.' in processing_time:
            second_units = processing_time.split('.')
            sec = int(second_units[0])
            mil = int(second_units[1].replace('s', ''))
            start = end - timedelta(seconds=sec) - timedelta(milliseconds=mil)
        else:
            sec = int(processing_time.replace('s', ''))
            start = end - timedelta(seconds=sec)

        start_end_times.append((start, end))

    """
    1. 시간 리스트에 항목이 있는지 확인한다
    2. 타임라인에서 하나 꺼내서 이전 이후 시간 계산하여 처리기간을 튜플로 만들고, 리스트에 넣는다.
    3. 새로 만든 처리기간을 기존 리스트와 비교한다.
        - 이때 만약 리스트에 있는 처리기간의 종료가, 지금 처리기간의 시작보다 작으면 pop 한다.
        - 돌면서 지금 처리시간의 시작시간과 끝 시간이 남아있는 시간들 중 몇개와 겹치는지 비교한다.
    """

    return answer


result1 = solution(["2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"])
result2 = solution([
    "2016-09-15 20:59:57.421 0.351s",
    "2016-09-15 20:59:58.233 1.181s",
    "2016-09-15 20:59:58.299 0.8s",
    "2016-09-15 20:59:58.688 1.041s",
    "2016-09-15 20:59:59.591 1.412s",
    "2016-09-15 21:00:00.464 1.466s",
    "2016-09-15 21:00:00.741 1.581s",
    "2016-09-15 21:00:00.748 2.31s",
    "2016-09-15 21:00:00.966 0.381s",
    "2016-09-15 21:00:02.066 2.62s"
])
