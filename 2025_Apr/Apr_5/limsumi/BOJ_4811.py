    def yak(n):
        dp = [[0] * 31 for i in range(31)]
        dp[0][0] = 1
        
        for i in range(n+1):
            for j in range(i + 1):
                if i < n:
                    dp[i + 1][j] += dp[i][j]
                if j < i:
                    dp[i][j + 1] += dp[i][j]
        
        return dp[n][n]
    
    while True:
        n=int(input())
    
        if n==0:
            break
        
        print(yak(n))
