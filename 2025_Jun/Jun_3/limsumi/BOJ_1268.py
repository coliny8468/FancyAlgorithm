N = int(input())

li = [list(map(int, input().split())) for i in range(N)]

common = [set() for i in range(N)]

for j in range(5):
    for i in range(N):
        for k in range(i + 1, N):
            if li[i][j] == li[k][j]:
                common[i].add(k)
                common[k].add(i)
ans = 0
ansI = 0
for i in range(len(common)):
    if ans < len(common[i]):
        ans = len(common[i])
        ansI = i + 1

if ansI == 0:
    print(1)
else:
    print(ansI)
