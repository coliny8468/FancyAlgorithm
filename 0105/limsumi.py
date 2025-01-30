from heapq import heappush, heappop, heapify
import sys

T=int(sys.stdin.readline())

for i in range(T):
    N=int(sys.stdin.readline())

    li=[]
    li=list(map(int, sys.stdin.readline().split()))

    heapify(li)

    
    summ=0
    while len(li)>1:
        x=heappop(li)
        y=heappop(li)

        tmp=x+y

        summ+=tmp


        heappush(li,tmp)


    print(summ)
