import sys

li = sys.stdin.readline().strip()
string = sys.stdin.readline().strip()

count = 0
index = 0

while index < len(string):
    maxx = 0
    for i in range(len(li)):
        tmp = 0
        while (
            index + tmp < len(string)
            and i + tmp < len(li)
            and string[index + tmp] == li[i + tmp]
        ):
            tmp += 1
        maxx = max(maxx, tmp)

    count += 1
    index += maxx

print(count)
