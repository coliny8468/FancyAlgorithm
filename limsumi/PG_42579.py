def solution(genres, plays):
    answer = []
    
    dd={}
    summ={}
    
    for i in range(len(genres)):
        if genres[i] in dd:
            dd[genres[i]].append((i,plays[i]))
            summ[genres[i]]+=plays[i]
        else:
            dd[genres[i]]=[]
            summ[genres[i]]=0
            dd[genres[i]].append((i,plays[i]))
            summ[genres[i]]+=plays[i]

    summ=sorted(summ.items(),reverse=True, key=lambda x:x[1])
    
    for i in range(len(summ)):
        cnt=0
        tmp = sorted(dd[summ[i][0]],reverse=True, key=lambda x:x[1])
        
        for j in range(min(2,len(tmp))):
            answer.append(tmp[j][0])
                
            
        
    return answer
