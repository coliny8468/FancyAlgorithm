string = input()
N = int(input())
ans = 0

for i in range(N):
    ring = input()
    tmp = ring + ring
    if string in tmp:
        ans += 1

print(ans)
