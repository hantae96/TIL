import sys
from collections import deque

#sys.stdin = open("TIL/CodingTest/baekjoon/자료구조1/input.txt")
n,m = map(int,sys.stdin.readline().rstrip().split())
array = list(map(int,sys.stdin.readline().rstrip().split()))
que = deque(range(1,n+1))
res = 0

for i in range(len(array)):
    while True:
        if que[0] == array[i]:
            que.popleft()
            break
        else:
            index = que.index(array[i])
            if index <= len(que)//2:
                que.rotate(-1)
                res +=1
            else:
                que.rotate(1)
                res +=1

    
print(res)


                