import sys

sys.setrecursionlimit(10**9)

N,M= map(int, sys.stdin.readline().rstrip().split())

box= [list(map(int, sys.stdin.readline().rstrip().split())) for i in range(N) ]



change = {'L': 'D', 'R':'U', 'U':'R', 'D':'L'}
dic= {'L':[0,-1], 'R':[0,1], 'D':[1,0], 'U':[-1,0]}

name=[[0]*(M+2) for i in range(N+2)]

count=1
for i in range(N):
    name[i+1][0]=count
    count+=1
for i in range(M):
    name[N+1][i+1]=count
    count+=1
for i in range(N-1,-1,-1):
    name[i+1][M+1]=count
    count+=1
for i in range(M-1,-1,-1):
    name[0][i+1]=count
    count+=1
ans=[]
def light(x,y, dir):
    global ans
    if 0<=x<N and 0<=y<M:

        if box[x][y]==1:
            nx=x+dic[change[dir]][0]
            ny=y+dic[change[dir]][1]
        
            light(nx,ny,change[dir])
        
        else:
            nx=x+dic[dir][0]
            ny=y+dic[dir][1]
            light(nx,ny,dir)
    else:

        if x<0:
            ans.append(str(name[0][y+1]))
        elif x<0:
            ans.append(str(name[x+1][1]))
        else:
            ans.append(str(name[x+1][y+1]))
        return 
    
for i in range(N):
    light(i,0,'R')
for i in range(M):
    light(N-1,i,'U')
for i in range(N-1,-1,-1):
    light(i,M-1,'L')
for i in range(M-1,-1,-1):
    light(0,i,'D')


print(' '.join(ans))
