def dp(n, x):
    if n == 0:
        return 1 if x > 0 else 0

    prev = 2 ** (n + 1) - 3
    patty = 2**n - 1

    if x == 1:
        return 0
    elif x <= 1 + prev:
        return dp(n - 1, x - 1)
    elif x == 1 + prev + 1:
        return patty + 1
    elif x <= 1 + prev + 1 + prev:
        return patty + 1 + dp(n - 1, x - (1 + prev + 1))
    else:
        return patty * 2 + 1


n, x = map(int, input().split())
print(dp(n, x))
