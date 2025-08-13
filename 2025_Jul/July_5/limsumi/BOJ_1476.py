E, S, M = map(int, input().split())

ans = 1
while True:
    e = (ans - 1) % 15 + 1
    s = (ans - 1) % 28 + 1
    m = (ans - 1) % 19 + 1

    if e == E and s == S and m == M:
        print(ans)
        break

    ans += 1
