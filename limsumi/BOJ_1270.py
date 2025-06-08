from collections import defaultdict

N=int(input())

for i in range(N):
    land= list(map(int, input().split()))

    flag=False
    dd = defaultdict(int)

    for i in range(1,len(land)):
        dd[land[i]]+=1

        if dd[land[i]]>land[0]//2:
            print(land[i])
            flag=True
            break
    if not flag:
        print("SYJKGW")
