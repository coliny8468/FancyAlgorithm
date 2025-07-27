li = [(int(input()), i + 1) for i in range(8)]

li.sort(reverse=True)

top5 = li[:5]
ans = 0
ansI = []
for i in top5:
    ans += i[0]
    ansI.append(i[1])

print(ans)
print(*sorted(ansI))
