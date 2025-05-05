N=int(input())

li=list(map(int, input().split()))

for i in range(N):
    li[i]-=N-i

print(max(li))
