def solution(my_string, letter):
    answer = ''
    for chr in my_string:
        if chr != letter:
            answer += chr
    return answer