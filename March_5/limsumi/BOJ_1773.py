x,y=map(int, input().split())

ans=[0]*(y+1)

li=[int(input()) for i in range(x)]

for i in li:
    tmp=i
    while True:
        ans[tmp]+=1
        tmp+=i
        
        if tmp>y:
            break

answer=0
for i in range(y+1):
    if ans[i]!=0:
        answer+=1

print(answer)
