import sys
from collections import deque

sys.stdin = open("input.txt")

result = []
N,K = map(int,input().split())
K-=1
circle = deque([i for i in range(1,N+1)])
next = 0
while len(circle) >0:
    circle.rotate(-K)
    result.append(circle.popleft())

print('<', end="")
for i in range(N):
    if (i != N -1):
        print(f'{result[i]}, ', end="")
    else:
        print(f'{result[i]}', end="")
print('>', end="")