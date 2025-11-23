def solution(brown, yellow):
    answer = []
    
    ver=0
    while True:
        ver+=1
        if yellow%ver==0:
            tmp = ver*2 + ((yellow//ver))*2 +4
            if brown == tmp:
                answer.append(yellow//ver+2)
                answer.append(ver+2)

                break
        if ver>=(yellow//ver):
            break
    return answer
