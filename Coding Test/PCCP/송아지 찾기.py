from collections import deque

def BFS(start,end,lst):
    dq = deque()
    dq.append(start)
    cnt = 0
    check_list = [0]*10000

    while dq:
        length = len(dq)
        for _ in range(length):
            current = dq.popleft()
            for i in lst:
                if current + i == end:
                    return cnt + 1
                if check_list[current] == 0:
                    check_list[current] = 1
                    dq.append(current+i)    
        cnt+=1
    

def solution(s, e):
    answer = 0
    lst = [-1,1,5]
    answer=BFS(s,e,lst)
    return answer

solution(5,14)