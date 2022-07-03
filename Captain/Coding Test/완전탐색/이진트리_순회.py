#이진트리 순회(깊이우선탐색)
#재귀함수로 구현
def DFS(v):
    if v>7:
        return 
    else:
        #함수 본연의 일
        print(v)
        # 왼쪽 노드
        DFS(v*2)
        #오른쪽 노드
        DFS(v*2+1)


if __name__=="__main__":
    DFS(1)