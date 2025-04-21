T=int(input())

for i in range(T):
    INF = int(1e9)

    n,m = map(int, input().split())

    graph = [[INF] * (n + 1) for _ in range(n + 1)]

    for a in range(1, n + 1):
        for b in range(1, n + 1):
            if a == b:
                graph[a][b] = 0

    for _ in range(m):
        a, b, c = map(int, input().split())
        graph[a][b] = c
        graph[b][a] = c

    for k in range(1, n + 1):
        for a in range(1, n + 1):
            for b in range(1, n + 1):
                graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

    p=int(input())


    friends=list(map(int, input().split()))

    maxx=2e9
    maxxIndex=0
    for q in range(1,n+1):
        summ=0
        for w in friends:
            summ+=graph[w][q]
        if summ<maxx:
            maxxIndex=q
            maxx=summ


    print(maxxIndex)
