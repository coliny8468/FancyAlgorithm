from collections import defaultdict

def solution(participant, completion):
    answer = ''
    
    dd=defaultdict(int)
    
    for i in range(len(participant)):
        dd[participant[i]]+=1
        
    
    for i in completion:
        dd[i]-=1
        
    for i in dd:
        if dd[i]>0:
            answer=i
    return answer
