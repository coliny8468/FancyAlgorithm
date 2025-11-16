import heapq

def solution(scoville, K):
    answer = 0
    
    heapq.heapify(scoville)
    
    
    while scoville and scoville[0]<K:
        answer+=1
        
        if len(scoville)==1:
            answer=-1
            break
        
        x=heapq.heappop(scoville)
        y=heapq.heappop(scoville)
        
        heapq.heappush(scoville,x+2*y)
        
    
    return answer
