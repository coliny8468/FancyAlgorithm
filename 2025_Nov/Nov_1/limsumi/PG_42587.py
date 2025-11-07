from collections import deque
def solution(priorities, location):
    
    answer = 1
    di={}
    for i in range(len(priorities)):
        di[i+1]=priorities[i]
    li=deque(list(range(1,len(priorities)+1)))
    while True:
        tmp=li.popleft()
        maxx=max(priorities)
        if di[tmp]==maxx:
            if tmp==location+1:
                break
            else:
                answer+=1
                priorities.remove(maxx)
                print(priorities)
        else:
            li.append(tmp)
 
    return answer
