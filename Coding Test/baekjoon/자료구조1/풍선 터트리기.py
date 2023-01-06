import sys
from collections import deque
import copy

sys.stdin = open("input.txt")
n = int(sys.stdin.readline())

result = []
ballon = deque(map(int,sys.stdin.readline().rstrip().split()))

for idx,val in enumerate(ballon):
    ballon[idx] = (val,idx+1)

#print(ballon)
val = 0
idx = 0
while len(ballon)>0:
    val,idx = ballon.popleft()
    result.append(idx)
    ballon.rotate(val-1)

for i in result:
    print(i,end=" ")
    