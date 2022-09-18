# 36분, 100/100
from typing import List, AnyStr


def solution(files: List[AnyStr]):
    """
    1. 파일명 분리
        if not 숫자
            file_token[HEAD] += c
        else:
            숫자 아닌게 나올 떄까지 계속 넣기
            file_token[NUMBER] += c

    file_token[TAIL] = 남은거
    """

    HEAD = 0
    NUMBER = 1
    INDEX = 2
    file_token_list = []

    for i in range(len(files)):
        file = files[i]
        file_token = [''] * 2
        file_token.append(i)
        is_first_numeric = True
        for i in range(len(file)):
            c = file[i]
            if c.isnumeric() and is_first_numeric:
                file_token[HEAD] = file[0:i].lower()
                file_token[NUMBER] += c
                is_first_numeric = False
            elif c.isnumeric() and not is_first_numeric:
                file_token[NUMBER] += c
            elif not c.isnumeric() and not is_first_numeric:
                break

        file_token[NUMBER] = int(file_token[NUMBER])
        file_token_list.append(file_token)

    file_token_list.sort()

    return [files[file_token[INDEX]] for file_token in file_token_list]