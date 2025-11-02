from collections import deque
def solution(bridge_length, weight, truck_weights):
    answer = 0

    li= deque(truck_weights)
    
    cur=deque([0 for i in range(bridge_length)])
    total=0
    while li:
        answer+=1
        tmp=li.popleft()
        tmpp=cur.popleft()

        total-=tmpp
        
        if total+tmp<=weight:
            total+=tmp
            cur.append(tmp)
            
        else:
            li.appendleft(tmp)
            cur.append(0)
            
        
    answer+=bridge_length
    
    return answer
        
