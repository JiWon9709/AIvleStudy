def solution(phone_book):
    answer = True
    # hash: 해시함수를 통해 특정값을 저장하는 방법
    phone_book.sort()
    book = {}
    for i in phone_book:
        if i[0] in book:
            book[i[0]].append(i)
        else:
            book[i[0]] = [i]
    # 앞자리가 같은거끼리만 비교
    for lst in book.values():
        length = len(lst)
        if length >= 2:
            for i in range(length-1):
                if lst[i] == lst[i+1][:len(lst[i])]:
                    return False
    # for i in range(len(phone_book)-1):
    #     for j in range(i+1, len(phone_book)):
    #         if phone_book[i][0] == phone_book[j][0]:
    #             for k in range(len(phone_book[i])):
    #                 if phone_book[i][k] != phone_book[j][k]:
    #                     break
    #             else:
    #                  return False   
    #         else:
    #             break
            # if phone_book[i] == phone_book[j][:len(phone_book[i])]:
            #     return False
    return answer