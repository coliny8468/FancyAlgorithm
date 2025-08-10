dic = {
    0: "zero",
    1: "one",
    2: "two",
    3: "three",
    4: "four",
    5: "five",
    6: "six",
    7: "seven",
    8: "eight",
    9: "nine",
}

N, M = map(int, input().split())


def change(num):
    if num < 10:
        return dic[num]
    else:
        return dic[num // 10] + " " + dic[num % 10]


li = [(change(i), i) for i in range(N, M + 1)]

li.sort(key=lambda x: x[0])

for i in range(len(li)):
    print(li[i][1], end=" ")
    if (i + 1) % 10 == 0:  # 10개마다 줄바꿈
        print()
