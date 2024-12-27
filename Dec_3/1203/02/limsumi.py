n = int(input())

top = list(map(int, input().split()))

li = []
ans = [0] * n

for i in range(n):
    while li:
        if li[-1][1] > top[i]:
            ans[i] = li[-1][0] + 1
            break
        else:
            li.pop()
    li.append([i, top[i]])


print(*ans)
