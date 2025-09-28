doc = input()
word = input()

ans, i = 0, 0
len = len(word)
while True:
    tmp = doc.find(word, i)
    if tmp == -1:
        break
    ans += 1
    i = tmp + len
print(ans)
