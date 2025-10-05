N = int(input())
ans = 100.0
cnt = 0

for _ in range(N):
    tmp = float(input())
    if cnt != 0:
        if cnt > tmp:
            ans *= cnt / tmp
    cnt = tmp

print(f"{ans:.2f}")
