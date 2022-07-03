def DFS(level,lst):
    if level == n+1:
        for i in lst:
            print(i,end=" ")
        print()
    else:
        ch[v]=1
        DFS(v+1)
        ch[v]=0
        DFS(v+1)
        DFS(level+1,lst+str(level))
        DFS(level+1,lst)


if __name__ == "__main__":
    n = 3
    DFS(1,)