from collections import deque

dic={0:[0,1,2,3], 1:[0,2,3],2:[0,1,2], 3:[0,2],
     4:[1,2,3], 5:[2,3], 6:[1,2], 7:[2],
     8:[0,1,3], 9:[0,3], 10: [0,1], 11:[0], 12:[1,3],
      13:[3], 14:[1], 15:[] }

# 동서남북
dx=[0,0,1,-1]
dy=[1,-1,0,0]

N,M=map(int, input().split())
li=[ list(map(int, input().split())) for i in range(M)]


visited=[[False]*N for i in range(M)]

def bfs(x,y):
      global tmp
      de=deque()
      de.append([x,y])
      visited[x][y]=True
      while de:
            tmp+=1
            x,y=de.popleft()
            nx=x
            ny=y
            

            for i in dic[li[x][y]]:
                  nx=dx[i]+x
                  ny=dy[i]+y

            
                  if 0<=nx<M and 0<=ny<N and not visited[nx][ny]:
                        visited[nx][ny]=True
                        de.append([nx,ny])



cnt=0
maxx=0
for i in range(N):
      for j in range(M):
            if not visited[j][i]:
                  cnt+=1
                  tmp=0
                  bfs(j,i)
                  maxx=max(tmp,maxx)


print(cnt)
print(maxx)

maxx=0
for i in [1,2,4,8]:
      for j in range(N):
            for k in range(M):
                  visited=[[False]*N for i in range(M)]
                  if(li[k][j]>=i):
                        li[k][j]-=i
                        tmp=0

                        bfs(k,j)

                        maxx=max(tmp,maxx)
                        li[k][j]+=i

print(maxx)

