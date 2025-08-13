import sys
from collections import deque

n = int(sys.stdin.readline())
ans = deque()

for _ in range(n):
    li = sys.stdin.readline().strip().split()

    if li[0] == "push":
        ans.append(int(li[1]))
    elif li[0] == "pop":
        print(ans.popleft() if ans else -1)
    elif li[0] == "size":
        print(len(ans))
    elif li[0] == "empty":
        print(0 if ans else 1)
    elif li[0] == "front":
        print(ans[0] if ans else -1)
    elif li[0] == "back":
        print(ans[-1] if ans else -1)
