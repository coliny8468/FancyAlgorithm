from collections import defaultdict

N= int(input())

dd=defaultdict(int)

li=[]
for i in range(N):
    tmp=list(input())
    li.append(tmp)

    c=len(tmp)
    for i in range(c):
        dd[tmp[i]]+=10**(c-i-1)


sortedDd=sorted(dd.items(),key=lambda item:item[1],reverse=True)

ans=0
count=9
for i in sortedDd:
    ans+=count*i[1]
    count-=1

print(ans)
