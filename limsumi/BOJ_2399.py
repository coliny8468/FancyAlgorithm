N=int(input())

li=list(map(int,input().split()))
ans=0
for i in range(N):
    for j in range(i,N):
        ans+=abs(li[i]-li[j])

print(ans*2)
