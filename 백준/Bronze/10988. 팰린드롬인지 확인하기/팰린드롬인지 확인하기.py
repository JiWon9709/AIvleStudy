word = input()
i = 0
length = len(word)
p = 1
while i < (length // 2):
    if word[i] != word[length - 1 -i]:
        p = 0
        break
    i += 1
print(p)