from collections import deque
import sys

sys.stdin = open("/Users/Hantae/Desktop/Programming/TIL/Coding Test/문제해결프로그래밍/input.txt","r")
start,location = map(int,input().split())

print(start,location)

dq = deque()
level = 0

distance_by_jump = [0 for i in range(10000)]
check_list = [0 for i in range(10000)]

distance_by_jump[start] = 0
check_list[start] = 1

# 루트 노드를 큐에 넣는다
dq.append(start)

while dq:
    now = dq.popleft()
    if now == location:
        break
    else:
        for i in (now-1,now+1,now+5):
            if 0<i<=10000 :
                if check_list[i] != 1:
                    dq.append(i)
                    distance_by_jump[i] = distance_by_jump[now] + 1
                    check_list[i] = 1


print(distance_by_jump[location])