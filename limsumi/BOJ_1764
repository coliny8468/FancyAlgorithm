import sys

N, M = map(int, sys.stdin.readline().rstrip().split())

hear = set(sys.stdin.readline().rstrip() for i in range(N))

see = set(sys.stdin.readline().rstrip() for i in range(M))


ans = hear & see

print(len(ans))

aans = sorted(list(ans))
for i in aans:
    print(i)
