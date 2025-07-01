cnt = 1

while True:
    n = int(input())
    if n == 0:
        break

    student = [input() for i in range(n)]
    li = [0] * (n + 1)

    for i in range(2 * n - 1):
        tmp = input()
        num, dir = tmp.split()
        num = int(num)
        li[num] += 1

    for i in range(1, n + 1):
        if li[i] == 1:
            print(f"{cnt} {student[i - 1]}")
            break

    cnt += 1
