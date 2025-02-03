T = int(input())

for i in range(T):
    x, y = map(int, input().split())

    if y == 0:
        print(0)
    else:
        if y % 4 == 0:
            tmp = x**4

        else:
            tmp = x ** (y % 4)

        if tmp % 10 == 0:
            print(10)
        else:
            print(tmp % 10)
