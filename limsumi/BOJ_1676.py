N = int(input())

cnt5 = 0
i = 5
while i <= N:
    cnt5 += N // i
    i *= 5

print(cnt5)
