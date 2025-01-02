N=int(input())

person=[]

for i in range(N):
    age,name=list(map(str, input().split()))

    person.append([int(age),i, name])

person.sort()

for i in range(N):
    print(str(person[i][0])+" "+person[i][2])

