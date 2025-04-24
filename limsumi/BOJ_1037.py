N= int(input())

li = list(map(int, input().split()))
li.sort()
tmp=N%2

if(N==1):
    ans=ans=li[0]*li[0]
elif(tmp==0):
    ans=li[N//2]*li[N//2-1]
else:
    ans=li[N//2]*li[N//2]

print(ans)
