import math

D, H, W = map(int, input().split())


summ=pow(H,2) + pow(W,2)

poww = pow(D,2)

tmp=math.sqrt(poww/summ)

height=int(tmp*H)
width=int(tmp*W)

print(height, width)
