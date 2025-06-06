x,y = map(str, input().split())

gap = len(y) - len(x)

minn=2e9

for i in range(gap+1):
    tmp=0
    for j in range(len(x)):
        if x[j] != y[i+j]:
            # print(x[j] , y[i+j])/
            tmp+=1

    minn=min(tmp, minn)

print(minn)
