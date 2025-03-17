total= int(input())

t=int(input())

summ=0

for i in range(t):
    x,y=map(int, input().split())

    summ+=x*y

if summ==total:
    print("Yes")
else:
    print("No")
