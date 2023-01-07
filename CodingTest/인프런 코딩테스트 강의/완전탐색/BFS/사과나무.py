import sys
from collections import deque
import time

start_time = time.time()
from collections import deque
import sys

sys.stdin = open("/Users/Hantae/Desktop/Programming/TIL/Coding Test/완전탐색/BFS/input.txt","r")

num = int(input())

martix = [list(map(int,input().split())) for i in range(num)]

total = 0

level = 0
check = 0
root_node = [num//2,num//2,level]
dq = deque()
dq.append(root_node)
total += martix[root_node[0]][root_node[1]]

check_list = [num*[0] for i in range(num)]
check_list[num//2][num//2] = 1

x = [-1,1,0,0]
y = [0,0,-1,1]


while dq:
    root_node = dq.popleft()
    if root_node[2] == (num//2):
        break
    else: 
        for i in range(4):
            if -1 < (root_node[0]+x[i]) <num and -1 < (root_node[1]+y[i]) < num:
                if check_list[root_node[0]+x[i]][root_node[1]+y[i]] != 1:
                    dq.append([root_node[0]+x[i],root_node[1]+y[i],root_node[2]+1])
                    total += martix[root_node[0]+x[i]][root_node[1]+y[i]]
                    check_list[root_node[0]+x[i]][root_node[1]+y[i]] = 1

for i in check_list:
    for j in i:
        print(j,end=" ")
    print()
print(total)
end_time = time.time()
print(end_time-start_time)
