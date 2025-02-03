N = int(input())
li = [int(input()) for _ in range(N)]
visited = [False] * (N + 1)
ans = set()

for i in range(N):
    path = []
    cur = i
    while True:
        if cur in path:
            start = path.index(cur)
            ans.update(path[start:])
            break
        if visited[cur]:
            break
        visited[cur] = True
        path.append(cur)
        cur = li[cur - 1]

print(len(ans))
for num in sorted(ans):
    print(num)
