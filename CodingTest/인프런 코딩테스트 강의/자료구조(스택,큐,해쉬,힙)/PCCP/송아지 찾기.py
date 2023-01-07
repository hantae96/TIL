from collections import deque

def BFS(start,end,lst):
    dq = deque()
    dq.append(start)
    cnt = 0
    check_list = [0]*10001

    while dq:
        length = len(dq)
        for _ in range(length):
            current = dq.popleft()
            for i in lst:
                if current + i == end:
                    return cnt + 1
                if current+i > 0 and current+i <= 10000 and check_list[current+i] == 0:
                    check_list[current+i] = 1
                    dq.append(current+i)    
        cnt+=1
    

def solution(s, e):
    answer = 0
    lst = [-1,1,5]
    answer=BFS(s,e,lst)
    return answer
