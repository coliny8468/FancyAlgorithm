number = input()
li = [0] * 10

for i in number:
    li[int(i)] += 1

tmp = li[6] + li[9]
li[6] = tmp // 2 + tmp % 2
li[9] = 0

print(max(li))
