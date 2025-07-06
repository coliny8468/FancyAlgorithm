N = int(input())
li = [tuple(map(int, input().split())) for _ in range(N)]

li.sort(key=lambda x: -x[2])

ans = []
cnt = {}

for country, student, score in li:
    if cnt.get(country, 0) < 2:
        ans.append((country, student))
        cnt[country] = cnt.get(country, 0) + 1
    if len(ans) == 3:
        break

for x, y in ans:
    print(x, y)
