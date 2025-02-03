import sys

N = int(sys.stdin.readline())

li = list(map(int, sys.stdin.readline().rstrip().split()))
ans = 0
while True:

    flag = False
    for i in range(N):
        if li[i] != 0:
            arrow = [li[i], i]
            flag = True
            break
    if not flag:
        break
    count = 0
    heigth = 0
    while True:
        if arrow[1] + count == N:
            break

        if li[arrow[1] + count] == arrow[0] - heigth:
            li[arrow[1] + count] = 0

            heigth += 1
        count += 1
    ans += 1


print(ans)
