import sys
from collections import defaultdict 

sys.stdin = open("Chapter_5/input.txt")
control = {"R":(0,1),"L":(-1,0),"U":(-1,0),"D":(1,0)}
start = [1,1]

n = int(input())
command = list(input().split())



for i in command:
    next_x = start[0] + control[i][0]
    next_y = start[1] + control[i][1]
    if 0< next_x and next_y < 6:
        start[0] = next_x
        start[1] = next_y

print(start)         


