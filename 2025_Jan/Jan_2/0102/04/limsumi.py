from collections import deque

N=int(input())

li=deque()

for i in range(10):
    li.append(i)
index=0

while li:
    x=li.popleft()
    index+=1
    if index==N:
        print(x)
        break
    


    for i in range(x%10):
        li.append(i + x*10)
        
else:
    print(-1)
