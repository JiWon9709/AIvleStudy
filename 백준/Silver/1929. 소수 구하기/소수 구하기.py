m, n = map(int, input().split())
def find_prime_list_under_number(m, n):
    prime_lst = set()
    if m <= 1:
        m += 1
    for i in range(m, n+1):
        for j in range(2, int(i**0.5)+1):
            if i % j == 0:
                break
        else:
            prime_lst.add(i)
    return sorted(list(prime_lst))

result = find_prime_list_under_number(m, n)
for i in result:
    print(i)