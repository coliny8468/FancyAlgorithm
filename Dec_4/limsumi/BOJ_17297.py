N = int(input())


def messi(N):
    leng = [5, 13]
    while leng[-1] < N:
        leng.append(leng[-1] + 1 + leng[-2])

    while len(leng) > 2:
        if N <= leng[-2]:
            leng.pop()
        elif N == leng[-2] + 1:
            return " "
        else:
            N -= leng[-2] + 1
            leng.pop()
            leng.pop()

    if len(leng) == 1:
        return "Messi"[N - 1]
    else:
        return "Messi Gimossi"[N - 1]


ans = messi(N)

if ans == " ":
    print("Messi Messi Gimossi")
else:
    print(ans)
