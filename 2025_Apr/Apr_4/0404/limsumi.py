from itertools import permutations
import sys

N = int(sys.stdin.readline().rstrip())

play = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

tmp = list(permutations(list(range(1, 10)), 9))
order = []
for i in range(len(tmp)):
    if tmp[i][3] == 1:
        order.append(tmp[i])


maxx = 0
for i in range(len(order)):
    this_order = order[i]
    score = 0
    cur_index = 0

    for j in range(N):
        this_play = play[j]
        one=0
        two=0
        three=0

        out_count = 0
        while out_count < 3:
            hit = this_play[this_order[(cur_index) % 9] - 1]

            if hit == 0:
                out_count += 1
            else:
                if three==1:
                    three=0
                    score+=1
                if two==1:
                    if hit==1:
                        three=1
                        two=0
                    else:
                        two=0
                        score+=1

                if one==1:
                    if hit==1:
                        two=1
                        one=0
                    elif hit==2:
                        three=1
                        one=0
                    else:
                        score+=1
                        one=0
            if hit==1:
                one=1
            elif hit==2:
                two=1
            elif hit==3:
                three=1
            elif hit==4:
                score+=1

            cur_index += 1

    maxx = max(score, maxx)

print(maxx)
