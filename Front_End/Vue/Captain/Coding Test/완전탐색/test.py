def DFS(v):
    if v > 6:
      return
      

    else:
        DFS(2*v)
        print(v)
        DFS(2*v+1)
        
n=5   
DFS(1)

