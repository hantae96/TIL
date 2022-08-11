def DFS(level,sum):
    global res
    
    if sum > m:
        return
    
    if sum == m:
        if res > level:
            res = level
            
    else:
        for i in range(n):
            DFS(level+1,sum+a[i])
            

if __name__ == "__main__":
    n = int(input())
    a = list(map(int,input().split()))
    m = int(input())
    
    res = float("inf")
    
    a.sort(reverse=True)
    DFS(0,0)