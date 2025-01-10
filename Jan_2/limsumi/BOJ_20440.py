import sys
from collections import defaultdict

N= int(sys.stdin.readline().rstrip())

li= [list(map(int, sys.stdin.readline().rstrip().split())) for i in range(N)]

mos=defaultdict(int)

for x,y in li:
    mos[x]+=1
    mos[y]-=1

tmp=0
maxx=0
ans=[0,0]
flag=False

for i in sorted(mos.keys()):
    tmp+=mos[i]
    if tmp>maxx:
        maxx=tmp
        ans[0]=i
        flag=True
    elif tmp<maxx and tmp -mos[i]==maxx and flag:
        ans[1]=i
        flag=False


print(maxx)
print(ans[0],ans[1])
