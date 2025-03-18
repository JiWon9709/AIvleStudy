a, b = map(int, input().split())

def gcd(a, b):
    i = 1
    max = i
    while i <= a and i <= b:
        if a % i == 0 and b % i == 0:
            max = i
        i += 1
    return max

# 24 18
# 24 > 18
# 24 > 36
# 48 > 36
# 48 < 54
# 72 < 54
# 72 = 72
def lmm(a, b):
    i = 1
    j = 1
    while a*i != b*j:
        if a*i < b * j:
            i += 1
        else:
            j += 1
    return a*i

print(gcd(a, b))
print(lmm(a, b))