import sys

input = sys.stdin.readline

li = [[0, 0] for _ in range(10)]

for _ in range(9):
    x, y = map(int, input().split())
    li[y][x] += 1


def lier(li):
    yes, no = set(), set()

    for i in range(1, 10):
        x, y = li[i]
        if x and y:
            return False
        elif x:
            no.add(i)
        elif y:
            yes.add(i)

    if len(yes) == 1:
        return yes
    if not yes:
        return set(range(1, 10)) - no


player = set()

for i in range(1, 10):
    x, y = li[i]
    if x == 1:
        li[i] = [0, y + 1]
        result = lier(li)
        li[i] = [x, y]
        if result:
            for p in result:
                player.add(p)

    if y == 1:
        li[i] = [x + 1, 0]
        result = lier(li)
        li[i] = [x, y]
        if result:
            for p in result:
                player.add(p)

if len(player) == 1:
    print(player.pop())
else:
    print(-1)
