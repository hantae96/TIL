def DFS(level,check_list):
    if level == n+1:
        return
    else:
        check_list[level] = 1
        DFS(level+1)
        check_list[level] = 0
        DFS(level+1) 


if __name__ == "__main__":
    n = 3
    check_list = [0]*(n+1)
    DFS(1,check_list)