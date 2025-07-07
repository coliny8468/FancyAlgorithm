from collections import defaultdict

U, N = map(int, input().split())
li = []
dd = defaultdict(int)

for i in range(N):
    x, y = input().split()
    y = int(y)
    li.append((x, y))
    dd[y] += 1

cnt = min(dd.values())

tmp = []
for k, v in dd.items():
    if v == cnt:
        tmp.append(k)

minn = min(tmp)

for x, y in li:
    if y == minn:
        print(x, y)
        break
