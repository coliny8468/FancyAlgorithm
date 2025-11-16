def solution(citations):
    answer = 0
    citations.sort()
    for i in range(len(citations)-1,0,-1):
        if citations[len(citations)-i-1]>=i+1:
            answer=i+1
            break
    return answer
