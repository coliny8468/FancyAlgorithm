import sys
from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
count = 0
while True:
    count += 1
    N = int(sys.stdin.readline().rstrip())
    maps = [list(map(int, sys.stdin.readline().rstrip().split())) for i in range(N)]
    if N == 0:
        break

    li = deque()

    li.append([0, 0])

    ans = [[2e9] * N for i in range(N)]
    ans[0][0] = maps[0][0]
    while li:
        x, y = li.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < N and ans[nx][ny] > ans[x][y] + maps[nx][ny]:
                li.append([nx, ny])
                ans[nx][ny] = ans[x][y] + maps[nx][ny]

    print("Problem", count, end="")
    print(":", ans[N - 1][N - 1])
