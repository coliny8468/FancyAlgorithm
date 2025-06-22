N, M = map(int, input().split())

li = [int(input()) for i in range(M)]

li.sort(reverse=True)

maxx = []

for i in range(min(N, M)):
    maxx.append(li[i] * (i + 1))

ans = 0
ansI = 0

for i in range(len(maxx)):
    if maxx[i] >= ans:
        ansI = i
        ans = maxx[i]

print(li[ansI], ans)
