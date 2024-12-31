import sys

N = int(sys.stdin.readline().rstrip())

cnt = 0
li = []
for i in range(N):
    new = int(sys.stdin.readline().rstrip())

    while li and li[-1] <= new:
        li.pop()
    cnt += len(li)
    li.append(new)


print(cnt)
