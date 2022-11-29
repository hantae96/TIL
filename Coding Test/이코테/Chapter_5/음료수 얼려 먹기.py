import sys
sys.stdin = open("Chapter_5/input.txt")


def backTracking(x,y):
    global graph
    global N,M
    if (0>x or M<x) or (0>y or y>N):
        return False

    if graph[x][y] == 0:
        graph[x][y] = 1
        backTracking(x,y-1)
        backTracking(x,y+1)
        backTracking(x-1,y)
        backTracking(x,y+1)
        return True
    else:
        return False




if __name__ == "__main__":
    N,M = map(int,input().split())
    
    graph = []
    res = 0
    for _ in range(N):
        graph.append(list(map(int,input())))

    for i in range(N):
        for j in range(M):
            if backTracking(i,j):
                res+=1

    print(res)