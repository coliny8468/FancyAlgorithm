N=int(input())

def checkRep(cli):
    length=len(cli)
    clength=len(cli)//2

    for i in range(2,clength+1):
       if cli[(length-i):] == cli[(length-2*i):(length-i)]:
            return False
    return True
        
count=0  
def backTracking(li):
    global count
    if len(li)==N:
        count+=1
        if count==1:
            for i in li:
                ans.append(i)
        return
    
    for i in range(1,4):
        if li[-1]!=i:
            li.append(i)
            if checkRep(li) and count!=1:
                backTracking(li)
            li.pop()

ans=[]
backTracking([1])

for i in ans:
    print(i, end='')
