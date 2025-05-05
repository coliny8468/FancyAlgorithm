while True:
    li=list(map(str,input().split()))

    if li==['#']:
        break
    ans=0
    for i in li:
        for j in i:
            if j.lower()==li[0][0]:
                ans+=1
    print(li[0][0],ans-1)
