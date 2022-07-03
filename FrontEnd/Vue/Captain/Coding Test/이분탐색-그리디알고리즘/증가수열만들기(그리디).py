from collections import deque

n = 5
lst = [2,3,5,1,3]
dqe =deque(lst)
res = []
cnt = 0 
tmp = 0

while lst:
    if len(dqe) == 1:
        res.append("L")
        cnt+=1
        break
        
    L=dqe[0]
    R=dqe[-1]
    
    
    
    if L < R and tmp < L:
        tmp=dqe.popleft()
        res.append("L")
        cnt+=1
        
    elif L > R and tmp < R:
        tmp=dqe.pop()
        res.append("R")
        cnt+=1
    
print(res)
print(cnt)



## 정답 풀이
n = 5
a = [2,4,5,1,3]

# 왼쪽
lt = 0
#오른쪽
rt = n-1

last = 0
res = ""
tmp = []

# 투포인터 while 문 조건
while lt<=rt:
    # last보단 커야지 다음 수열의 항이 될 수 있음.
    if a[lt] > last:
        tmp.append((a[lt],"L"))
    if a[rt] > last:
        tmp.append((a[rt],"R"))
        
    # 옵션없이 sort 하면 오름차순
    # 제일 작은 값이 왼쪽에 오게됨
    tmp.sort()
    
    # tmp에 아무것도 포함되지 않으면 while문 종료 == last보다 큰 수 가 없는 것임으로 조건을 만족하지 않는다.
    if len(tmp)==0:
        break
    else:
        res = res+tmp[0][1]
        last = tmp[0][0]
        if tmp[0][1]=="L":
            lt+=1
        else:
            rt-=1
    
    tmp.clear()
    

print(len(res))
print(res)
