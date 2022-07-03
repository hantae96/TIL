import sys
sys.stdin = open("input.txt","r")

#상우하좌 탐색할때 팁
dx = [-1,0,1,0]
dy = [0,1,0,-1]

n = int(input())
a = [list(map(int,input().split())) for _ in range(n)]

# 주변 테두리를 0으로 감싸는 코드
a.insert(0,[0]*n)
a.append([0]*n)
for x in a:
    x.insert(0,0)
    x.append(0)
    
cnt = 0
for i in range (1,n+1):
    for j in range(1,n+1):
        # all 안에 있는 모든 조건이 참일 때 참!!
        if all(a[i][j]>a[i+dx[k][j+dy[k]]] for k in range(4))
        cnt+=1
        
print(cnt)