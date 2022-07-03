import sys

sys.setrecursionlimit(10**7)

def DFS(level,sum):
    global res
    if level == n:
        res.append(sum)
    else:
        check_list[level]=1
        if check_list[level] != 1:
            DFS(level+1,sum+sum[level])
        check_list[level]=0
        DFS(level+1,sum)

    



if __name__ == "__main__":
    n = int(input())
    arr = [1,3,5,6,7,10]
    check_list = [0]*n+1
    res = []

    DFS(0,0)

    print(res)