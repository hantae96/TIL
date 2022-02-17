import sys
from collections import deque

n,k = 8,3

# a부터 b까지 list에 생성된다.
dq = list(range(1,n+1))
dq = deque(dq)

while dq:
    for _ in range(k-1):
        #제일 앞에 자료가 cur에 들어감
        cur=dq.popleft()
        # 제일 뒤로 들어감
        dq.append(cur)
    #3번째 사람을 pop
    dq.popleft()
    if len(dq)== 1:
        print(dq[0])
        dq.popleft()
        

        
        