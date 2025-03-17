cx,cy,rx,ry=map(int, input().split())


print(min(cx,cy,abs(rx-cx),abs(ry-cy)))
