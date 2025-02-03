import sys

N,K = map(int, sys.stdin.readline().rstrip().split())

buy=0

while True:
    
    tmp=N+buy

    res=0

    while tmp>1:
        res+=tmp%2
        tmp//=2


    if res <K:
        break
    
    buy+=1


print(buy)
