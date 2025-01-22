from collections import deque

N=int(input())

tmp=format(N+1, 'b')


ans=deque()
for i in str(tmp):

    if i=="1":
        ans.append('7')
    else:
        ans.append('4')
ans.popleft()

print(''.join(ans))

# 4 7 44 47 74 77 444 447 474 477 7

# 1 10 11 100 101 110 111  
