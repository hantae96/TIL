from collections import deque
import sys

sys.stdin = open("/Users/Hantae/Desktop/Programming/TIL/Coding Test/완전탐색/BFS/input.txt","r")

martix = []
for i in range(7):
    martix.append(list(map(int,input().split())))


check_list = [[0]*7 for i in range(7)]

dq = deque()
cnt = 0
dq.append([0,0,0])
check_list[0][0] = 1
x = [0,0,1,-1]
y = [1,-1,0,0]
tmp = 10000000000

while dq:
    now = dq.popleft()
    if now[0] == 6 and now[1] == 6:
        if tmp > now[2]:
            tmp = now[2]
            break
    else:
        for i in range(4):
            if -1 < now[0]+x[i] < 7 and -1 < now[1]+y[i] < 7:
                if check_list[now[0]+x[i]][now[1] + y[i]] != 1:
                    if martix[now[0]+x[i]][now[1] + y[i]] != 1:
                        dq.append([now[0]+x[i],now[1]+y[i],now[2]+1])
                        check_list[now[0]+x[i]][now[1] + y[i]] = 1

if tmp == 10000000000:
    print("-1")
else:
    print(tmp)
