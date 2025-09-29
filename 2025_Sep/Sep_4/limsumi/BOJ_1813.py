from collections import Counter

N = int(input())
li = list(map(int, input().split()))
cnt = Counter(li)

ans = -1

for i in range(0, 51):
    if cnt.get(i, 0) == i:
        if i > ans:
            ans = i

print(ans)
