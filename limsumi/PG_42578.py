from collections import defaultdict

def solution(clothes):
    answer = 1
    
    dd=defaultdict(int)
    
    for x,y in clothes:
        dd[y]+=1
        
    for i in dd.values():
        answer*=i+1
                
    
    return answer-1
