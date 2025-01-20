x, y = map(int, input().split())
k, gap = map(int, input().split())

minn = k - gap
maxx = k + gap

start = max(x, minn)
end = min(y, maxx)

if start <= end:
    print(end - start + 1)
else:
    print("IMPOSSIBLE")
