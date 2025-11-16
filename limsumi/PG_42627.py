import heapq

def solution(jobs):
    answer = 0
    jobs.sort()
    hq=[]
    
    length=len(jobs)
    i=0
    time=0
    while i < len(jobs) or hq:
        while i < len(jobs) and jobs[i][0] <= time:
            heapq.heappush(hq, (jobs[i][1], jobs[i][0])) 
            i += 1
        if hq:
            x,y=heapq.heappop(hq)
            time+=x
            answer+=time-y
        else:
            time = jobs[i][0]

    
    return answer//length
