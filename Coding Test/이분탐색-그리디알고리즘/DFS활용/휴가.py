def DFS(level):
    if level == n+1:
        for i in range(1,n+1):
            if check_list[i] == 1:
                print(i,end="")
        print("")
    else:
        check_list[level]=1
        DFS(level+1)
        check_list[level]=0
        DFS(level+1)



if __name__ == "__main__":
    n = int(input())
    check_list=[0]*(n+1)
    DFS(1)