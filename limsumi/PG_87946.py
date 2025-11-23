from itertools import permutations

def solution(k, dungeons):
    answer = -1
    
    for order in permutations(dungeons, len(dungeons)):
        cur=k
        count=0
        
        
        for i in order:
            x,y = i
            
            if cur >= x:
                cur -= y
                count+=1
                
            else:
                break
        answer=max(answer, count)
    return answer
