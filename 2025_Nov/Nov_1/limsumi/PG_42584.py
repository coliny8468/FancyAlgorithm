from collections import deque

def solution(prices):
    answer = [0]*len(prices)
    
    
    li=deque(list(range(len(prices))))
    cur=deque()
    
    past=0
    for i in range(len(prices)):
        if cur:
            if prices[cur[-1]]<=prices[i]:
                pass
            else:
                while cur and prices[cur[-1]]>prices[i]:
                    tmp =cur.pop()
                    answer[tmp]=i-tmp
            cur.append(i)
        else:
            cur.append(i)
    
    while cur:
        tmp=cur.pop()
        answer[tmp]=len(prices)-tmp-1
    
    return answer
