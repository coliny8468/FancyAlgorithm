N = int(input())
ans = set()

for _ in range(N):
    x, y = input().split()
    if y == "enter":
        ans.add(x)
    else:
        ans.remove(x)

rans = sorted(ans, reverse=True)

print("\n".join(rans))
