n = int(input())
li = [int(input()) for i in range(n)]

summ = 0
for i in range(n):
    if i % 2 == 0:
        summ += li[i]
    else:
        summ -= li[i]

ans = [0] * n
ans[0] = summ // 2

for i in range(1, n):
    ans[i] = li[i - 1] - ans[i - 1]

for i in ans:
    print(i)
