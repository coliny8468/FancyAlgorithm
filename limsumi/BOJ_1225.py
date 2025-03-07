import sys

x,y=sys.stdin.readline().split()

sumx=0
sumy=0

for i in range(len(x)):
    sumx+=int(x[i])

for i in range(len(y)):
    sumy+=int(y[i])


print(sumx*sumy)
