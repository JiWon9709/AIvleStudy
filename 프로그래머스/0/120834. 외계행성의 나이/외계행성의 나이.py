def solution(age):
    answer = str(age)
    age_set = {'0':'a', '1':'b', '2':'c', '3':'d', '4':'e', '5':'f', '6':'g', '7':'h', '8':'i', '9':'j'}
    result = ''
    for num in answer:
        result += age_set[num]
    return result