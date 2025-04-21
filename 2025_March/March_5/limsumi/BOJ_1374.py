import sys

r=int(sys.stdin.readline())

room=[0]*r
li=[]
for i in range(r):
    x,y,z=map(int, sys.stdin.readline().split())

    li.append((y,z))

li.sort()
for x,y in li:
    for i in range(r):
        if room[i]<=x:
            room[i]=y  
            break

ans=0
for i in range(r):
    if room[i]!=0:
        ans+=1
print(ans)
