def solution(array, commands):
    answer = []
    
    for x,y,z in commands:
        new_li=array[x-1:y]
        
        new_li.sort()
        # print(new_li)
        answer.append(new_li[z-1])
    return answer
