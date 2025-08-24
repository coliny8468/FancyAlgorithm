N = int(input())
li = [list(input()) for _ in range(N)]

dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

ans = [[""] * N for _ in range(N)]

for i in range(N):
    for j in range(N):
        if li[i][j] != ".":
            ans[i][j] = "*"
        else:
            count = 0
            for k in range(8):
                nx, ny = i + dx[k], j + dy[k]
                if 0 <= nx < N and 0 <= ny < N and li[nx][ny] != ".":
                    count += int(li[nx][ny])
            if count >= 10:
                ans[i][j] = "M"
            else:
                ans[i][j] = str(count)

for x in ans:
    print("".join(x))
