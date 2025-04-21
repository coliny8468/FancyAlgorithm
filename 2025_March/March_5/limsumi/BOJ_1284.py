while True:
    x=list(input())

    if x==['0']:
        break
    summ=0
    for i in x:
        if i=='0':
            summ+=4
        elif i=='1':
            summ+=2
        else:
            summ+=3
    summ+=len(x)+1
    print(summ)
