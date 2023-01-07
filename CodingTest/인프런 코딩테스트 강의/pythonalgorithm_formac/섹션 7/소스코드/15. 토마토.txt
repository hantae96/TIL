import sys
from collections import deque
#sys.stdin=open("input.txt", "r")
dx=[-1, 0, 1, 0]
dy=[0, 1, 0, -1]
n, m=map(int, input().split())
board=[list(map(int, input().split())) for _ in range(m)]
Q=deque()
dis=[[0]*n for _ in range(m)]
for i in range(m):
    for j in range(n):
        if board[i][j]==1:
            Q.append((i, j))
while Q:
    x, y=Q.popleft()
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if 0<=nx<m and 0<=ny<n and board[nx][ny]==0:
            board[nx][ny]=1
            dis[nx][ny]=dis[x][y]+1
            Q.append((nx, ny))
flag=1
for i in range(m):
    for j in range(n):
        if board[i][j]==0:
            flag=0
result=0
if flag==1:
    for i in range(m):
        for j in range(n):
            if dis[i][j]>result:
                result=dis[i][j]
    print(result)
else:
    print(-1)