import sys
sys.stdin = open("Chapter_5/input.txt")

def backTracking(x,y):
    global graph
    global n,m

    if x<0 or x >= n or y<0 or y >= m:
        return False
    
    # 방문하지 않았으면
    if graph[x][y] == 0:
        graph[x][y] = 1
        backTracking(x,y-1)
        backTracking(x,y+1)
        backTracking(x-1,y)
        backTracking(x+1,y)
        return True
    return False


if __name__ == "__main__":
    n,m = map(int,input().split())
    graph = []
    count = 0

    for _ in range(n):
        graph.append(list(map(int,input())))

    for i in range(n):
        for j in range(m):
            if backTracking(i,j):
                count +=1

    print(count)