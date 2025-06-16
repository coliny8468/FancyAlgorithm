li=list(map(int,input()))
zero=0
one=0

for i in range(len(li)):
    if li[i]==0:
        if i==0 or li[i-1]==1:
            zero+=1
    else:
        if i==0 or li[i-1]==0:
            one+=1
print(min(zero,one))
