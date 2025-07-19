graph = [[0] * 100 for i in range(100)]

N = int(input())

for i in range(N):
    x, y = map(int, input().split())
    for i in range(x, x + 10):
        for j in range(y, y + 10):
            graph[i][j] = 1

count = 0
for i in range(100):
    for j in range(100):
        if graph[i][j] == 1:
            count += 1

print(count)
