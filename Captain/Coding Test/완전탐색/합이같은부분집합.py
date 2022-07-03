def DFS(V,sum):
    if V+1 == n:
        if sum == (total-sum):
            print("True")
            sys.exit()
        else:
            DFS(v+1,sum+a[v])
            DFS(v+1,sum)
        

if __name__ == "__main__":
    n = int(input())
    a  = list(map(int,input().split()))
    total = sum(a)
    DFS(0,0)