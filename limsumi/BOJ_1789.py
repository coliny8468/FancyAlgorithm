N = int(input())

cnt = 0
while True:
    cnt += 1
    if cnt * (cnt + 1) // 2 > N:
        cnt -= 1
        break

print(cnt)
