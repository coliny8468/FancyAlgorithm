from collections import defaultdict, Counter

dic = defaultdict(int)

n = int(input())

for _ in range(n):
    word = input().strip()
    if len(word) == 1:
        key = (word[0], "")
    elif len(word) <= 2:
        key = (word[0], word[-1], "")
    else:
        key = (word[0], word[-1], tuple(sorted(Counter(word[1:-1]).items())))
    dic[key] += 1

m = int(input())
for i in range(m):
    words = input().strip().split()

    result = 1
    for word in words:
        if len(word) == 1:
            key = (word[0], "")
        elif len(word) <= 2:
            key = (word[0], word[-1], "")
        else:
            key = (word[0], word[-1], tuple(sorted(Counter(word[1:-1]).items())))
        result *= dic[key]

    print(result)
