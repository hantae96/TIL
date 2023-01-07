import sys
from collections import deque
sys.stdin = open("Chapter_5/input.txt")

# n,m = map(int,input().split())

# graph = []
# dq = deque()
# for _ in range(n):
#     graph.append(list(map(int,input())))

# ##BFS
# start = (0,0)
# dq.append(start)
# graph[0][0] = 0
# count = 0
# while dq:
#     current = dq.popleft()        # 4방향으로 큐에 차례대로 넣는다
#     if current == (n-1,m-1):
#         print(count)
#         break
#     for i in [(0,1),(1,0),(0,-1),(-1,0)]:
#         next_x = current[0]+i[0]
#         next_y = current[1]+i[1]
        
#         if -1<next_x<n and -1<next_y<m:
#             if graph[next_x][next_y] == 1:
#                 dq.append((next_x,next_y))
#                 graph[next_x][next_y] = 0
#     count+=1


n,m = map(int,input().split())
graph = []
for i in range(n):
    graph.append(list(map(int,input())))

    dx = [-1,1,0,0]
    dy = [0,0,-1,1]

def bfs(x,y):
    queue = deque()
    queue.append((x,y))
    
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
        
            if graph[nx][ny] == 0:
                continue
        
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] +1
                queue.append((nx,ny))

    return graph[n-1][m-1]

print(bfs(0,0))