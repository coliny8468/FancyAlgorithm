N = int(input())

li = [list(input()) for i in range(N)]
hans = 0
vans = 0
for i in range(N):
    cnt = 0
    for x in li[i]:
        if x == ".":
            cnt += 1
        else:
            if cnt >= 2:
                hans += 1
            cnt = 0
    if cnt >= 2:
        hans += 1

for i in range(N):
    cnt = 0
    for j in range(N):
        if li[j][i] == ".":
            cnt += 1
        else:
            if cnt >= 2:
                vans += 1
            cnt = 0
    if cnt >= 2:
        vans += 1

print(hans, vans)
