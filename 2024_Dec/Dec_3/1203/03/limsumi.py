import heapq
import sys


def prim(n, graph):
    global minn
    visited = [False] * n
    heapqq = [(0, 0)]

    while heapqq:
        cos, cur = heapq.heappop(heapqq)
        if visited[cur]:
            continue
        visited[cur] = True
        minn += cos

        for n, w in graph[cur]:
            if not visited[n]:
                heapq.heappush(heapqq, (w, n))
    return


while True:

    n, m = map(int, sys.stdin.readline().rstrip().split())

    if n == 0 and m == 0:
        break
    li = [[] for _ in range(n)]
    summ = 0
    for i in range(m):
        first, second, cost = map(int, sys.stdin.readline().rstrip().split())
        summ += cost
        li[first].append((second, cost))
        li[second].append((first, cost))

    minn = 0
    prim(n, li)
    print(summ - minn)
