from collections import defaultdict

li=list()

while True:
    tmp= list(input())
    dd=defaultdict(int)
    if tmp==["-"]:
        break
    for i in tmp:
        dd[i]+=1
    
    li.append(dd)

while True:

    ans=defaultdict(int)
    tmp= list(input())

    dd=defaultdict(int)
    if tmp==["#"]:
        break
    for i in tmp:
        dd[i]+=1
    dl=[i for i in dd if dd[i]!=dd.default_factory()]
    for i in li:
        flag=False
        for j in i:
            if i[j]>dd[j]:
                flag=True

        if not flag:

            il=[j for j in i if i[j]!=i.default_factory()]


            for k in list(set(dl).intersection(il)):
                ans[k]+=1

    if(ans):
        maxx=max(ans.values())
        minn=min(ans.values())



        dans=[i for i in ans if ans[i]!=ans.default_factory()]

        sortedAns=sorted(ans)

        minus=set(set(dl)).difference(set(dans))
        if minus:
            for k in minus:
                print(k,end="")
            print("",0,end=" ")   
        else:
            for k in sortedAns:
                if ans[k]==minn:
                    print(k,end="")
            print("",minn,end=" ")   
        
        for k in sortedAns:
            if ans[k]==maxx:
                print(k,end="")
        print("",maxx,end="\n")    
    else:
        for k in sorted(list(set(dl))):
            print(k,end="")
        print("",0, end=" ")
        for k in sorted(list(set(dl))):
            print(k,end="")
        print("",0)
