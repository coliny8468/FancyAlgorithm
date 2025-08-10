N = int(input())

li = [tuple(map(int, input().split())) for _ in range(N)]

li.sort(key=lambda x: (x[1], x[0]))

for x, y in li:
    print(x, y)
