graph = [[] for _ in range(3)]

graph[0].append((1,7))
graph[0].append((2,5))



visited = [False] * 9

def dfs(graph,v,visited):
    visited[v] = True
    print()
    for i in graph[v]:
        if not visited[i]:
            dfs(graph,i,visited)
    

def bfs(graph,start,visited):
    queue = deque([start])
    visited[start] = True

    while queue:
        v = queue.popleft()
        print()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
    


