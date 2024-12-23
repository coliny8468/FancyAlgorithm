N = int(input())

ans = 0
for i in range(N):
    word = list(input())

    nword = ["!"]

    for x in word:
        if nword[-1] != x:
            nword.append(x)

    if len(nword) == len(set(nword)):
        ans += 1

print(ans)
