import sys

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
dic = {"U": 0, "D": 1, "L": 2, "R": 3}


def dfs(x, y, count):
    global flag
    visited[x][y] = count
    dir = li[x][y]
    nx, ny = x + dx[dic[dir]], y + dy[dic[dir]]

    if visited[nx][ny] == 2e9:
        dfs(nx, ny, count)
    elif visited[nx][ny] != count:
        flag = True


N, M = map(int, input().split())
li = [list(input().rstrip()) for i in range(N)]
visited = [[2e9] * M for i in range(N)]
count = 0
no = 0
for i in range(N):
    for j in range(M):
        if visited[i][j] == 2e9:
            flag = False
            count += 1
            dfs(i, j, count)
            if flag:
                no += 1

print(count - no)
