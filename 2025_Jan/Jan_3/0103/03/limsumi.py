import sys
from collections import deque
sys.setrecursionlimit(10**9)
N=int(sys.stdin.readline().rstrip())

li=list(range(1,N+1))

bridge=[[] for i in range(N+1)]
x,y=0,0

for i in range(N-2):
    x,y= map(int, sys.stdin.readline().rstrip().split())
    bridge[x].append(y)
    bridge[y].append(x)


tmp=deque()

tmp.append(x)
tmp.append(y)
visited=[False]*(N+1)

visited[x]=True
visited[y]=True


while tmp:
    q=tmp.popleft()
    for i in bridge[q]:
        if not visited[i]:
            visited[i]=True
            tmp.append(i)

    
ans=0
for i in range(1,N+1):
    if not visited[i]:
         ans=i
         break
if N==2:
     print("1 2")
else:
    print(x, ans)
