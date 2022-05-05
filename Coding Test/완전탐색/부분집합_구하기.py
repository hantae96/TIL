# 상태트리의 구현


def DFS(V):
    # 종착노드까지 오면
    if V == n+1:
        
        for i in range(1,n+1):
            if check[i]==1:
                print(i,end=" ")
            print()
    
    else:
        #사용한다
        check[V] =1
        #ex) 사용한다 가정하고 DFS(2)
        DFS(V+1)
        #사용하지 않는다
        check[V] = 0
        DFS(V+1)
        

if __main__ == "__main__":
    n = 3
    # 원소를 사용했냐 안했냐 체크변수
    check = [0]*(n+1)
    # 루트 노드 부터 시작
    DFS(1)