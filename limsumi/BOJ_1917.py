N, M = map(int, input().split())

if N == 0:
    print(0)
else:
    li = list(map(int, input().split()))
    ans = 1
    tmp = 0

    for i in li:
        if tmp + i <= M:
            tmp += i
        else:
            ans += 1
            tmp = i

    print(ans)
