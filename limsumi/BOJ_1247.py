for i in range(3):
    N=int(input())

    li= [int(input()) for i in range(N)]

    if sum(li)>0:
        print('+')
    elif sum(li)==0:
            print(0) 
    else:
         print('-')
