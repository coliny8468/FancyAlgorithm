import heapq
def solution(operations):
    answer = []
    hq=[]
    for i in operations:
        x,y=map(str,i.split())
        if x=='I':
            heapq.heappush(hq, float(y))
        elif y=='1' and hq:
            
            hq.remove(max(hq))
            heapq.heapify(hq)
        
        elif y=='-1' and hq:
            heapq.heappop(hq)
    if(hq):
        x=hq[0]
        y=max(hq)
        
        answer=[y,x]
    else:
        answer=[0,0]
    return answer
