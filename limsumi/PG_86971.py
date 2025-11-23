from itertools import combinations
from collections import deque

def solution(n, wires):
    answer = 100
    
    for net in combinations(wires, len(wires)-1):
        
        li= [[] for i in range(101)]
        for i,j in net:
            li[i].append(j)
            li[j].append(i)
        
        visited=[wires[0][0]]
        tmp=deque()
        tmp.append(wires[0][0])
        
        while tmp:
            x=tmp.popleft()
            
            for i in li[x]:
                if i not in visited:
                    tmp.append(i)
                    visited.append(i)
                    
        count=abs((n-len(visited)) - len(visited) )
        answer=min(count,answer)
        
    return answer

    
