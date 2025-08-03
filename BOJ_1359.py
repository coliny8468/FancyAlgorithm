from math import comb

N, M, K = map(int, input().split())

lotto = comb(N, M)
buza = 0

for i in range(K, M + 1):
    if N - M >= M - i:
        buza += comb(M, i) * comb(N - M, M - i)

print(buza / lotto)
