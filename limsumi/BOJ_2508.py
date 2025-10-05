T = int(input())

for _ in range(T):
    input()
    R, C = map(int, input().split())
    li = [list(input().strip()) for _ in range(R)]

    ans = 0
    for i in range(R):
        for j in range(C - 2):
            if li[i][j : j + 3] == [">", "o", "<"]:
                ans += 1

    for i in range(R - 2):
        for j in range(C):
            if li[i][j] == "v" and li[i + 1][j] == "o" and li[i + 2][j] == "^":
                ans += 1

    print(ans)
