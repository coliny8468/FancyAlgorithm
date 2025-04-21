from collections import defaultdict

T= int(input())

dic=defaultdict(int)

for i in range(T):
    x= input()
    dic[x[0]]+=1
ans=[]

for i in dic.keys():
    if dic[i]>=5:
        ans.append(i)

ans.sort()

if ans:
    for i in ans:
        print(i[0], end="")
else:
    print("PREDAJA")
