from collections import deque

N, M = map(int, input().split())
arr = list(map(int, input().split()))

li = deque(range(1, N + 1))
count = 0

for x in arr:
    tmp = li.index(x)

    if tmp <= len(li) // 2:
        li.rotate(-tmp)
        count += tmp
    else:
        li.rotate(len(li) - tmp)
        count += len(li) - tmp

    li.popleft()

print(count)
