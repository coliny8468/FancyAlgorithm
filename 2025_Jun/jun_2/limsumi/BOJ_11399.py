n =int(input())
li=list(map(int,input().split()))
li.sort()

ans=0
tmp=0
for i in li:
    tmp+=i
    ans+=tmp

print(ans)
