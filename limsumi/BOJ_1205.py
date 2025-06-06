N, score, P = map(int, input().split())
index=-1
if(N>0):
    rank = list(map(int, input().split()))

    rank.sort(reverse=True)

    for i in range(N):
        if rank[i]>score:
            continue
        else:
            index=i+1
            break

    if(N>=P and rank[P-1]==score):
        print(-1)
    elif(N<P and index==-1):
        print(N+1)
    else:
        print(index)
else:
    print(1)
