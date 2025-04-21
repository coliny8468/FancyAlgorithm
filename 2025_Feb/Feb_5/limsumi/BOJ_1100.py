li= [list(input()) for i in range(8)]

count=0
for i in range(8):
    for j in range(8):
        if i%2==0:
            if j%2==0:
                if li[i][j]=='F':
                    count+=1
        else:
            if j%2!=0:
                if li[i][j]=='F':
                    count+=1
print(count)
