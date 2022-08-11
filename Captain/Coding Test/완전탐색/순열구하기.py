def DFS(level,pre):
    if level == N+1:
        return
    else:
        for i in range(1,M+1):
            arr[i+1]=i
            DFS(level+1,i)


if __name__ == "__main__":
    N,M = 3,2
    arr = [0]*(N+1)
    DFS(0,0)
    
#####################

def DFS(L):
    global cnt
    if L==m:
        for j in range(L):
            print(res[j],end=" ") 
        print()
        cnt+=1
    else:
        for i in range(1,n+1):
            if ch[i]==0:
                ch[i]=1
                res[L]=i
                DFS(L+1)
                ch[i]=0
                
    
if __name__ == "__main__":
    n.m = map(int,input().split())
    res = [0]*n
    ch=[0]*(n+1)
    cnt = 0
    DFS(0)
    print(cnt)