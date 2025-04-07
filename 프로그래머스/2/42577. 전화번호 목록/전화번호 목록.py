def solution(phone_book):
    answer = True
    hash_map = {}
    # phone_book을 해시맵에 저장
    for i in phone_book:
        hash_map[i] = 1
    for phone_number in phone_book:
        tmp = ""
        # 해시맵에 저장되어있는 번호의 숫자 하나씩 가져오기
        for number in phone_number:
            tmp += number # tmp에 하나씩 넣어서 있는지 확인
            # print("phone_number:",phone_number,"tmp:", tmp)
            if tmp in hash_map and tmp != phone_number:
                return False
    return answer