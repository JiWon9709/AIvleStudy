input = input()


def find_count_to_turn_out_to_all_zero_or_all_one(string):
    answer = 0
    # 연속된 하나이상의 숫자를 잡고 모두 뒤집기
    # 앞뒤 검사하면서 같으면 pass 다르면 카운트
    # 다시 바뀌면 pass
    length = len(string)
    start, end = length, 0
    for i in range(length):
        if i+1 < length:
            if string[i] != string[i+1]:
                # if i == length -2:
                #     answer += 1
                if start == length:
                    start = i+1
                    continue
                if end == 0:
                    end = i+1
            if start < length and end > 0:
                answer += 1
                start, end = length, 0
    if start < length:
        answer += 1
    return answer

result = find_count_to_turn_out_to_all_zero_or_all_one(input)
print(result)