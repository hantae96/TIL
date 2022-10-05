def DFS(level):
    if level == num+1:
        for i in lst:
            if i!=0:
                print(i,end=" ")
        print()
    else:
        lst[level] = level
        DFS(level+1)
        lst[level] = 0
        DFS(level+1)

if __name__ == "__main__":
    num = 3
    lst = [0]*(num+1)
    level = 1
    DFS(level)