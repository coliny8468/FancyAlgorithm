import math
N = int(input())

ans = 2e9
c= int(math.isqrt(N)) + 2
for i in range(2, c):
    tmp = max(2, (N + i - 1) // i) 
    ans = min(ans, i + tmp)

print(2 * (ans - 2))
