a, b = map(int, input().split())

List = [list(map(int, input().split())) for _ in range(2)]

A = List[0]
B = List[1]

C = list(set(A).intersection(B))

C_cnt = len(C)

A_C = a - C_cnt
B_C = b - C_cnt
print(A_C + B_C)
