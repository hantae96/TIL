from collections import deque

num = 5
safety_weight = 140

lst = [90,50,70,100,60]
lst.sort()
lst_to_deque = deque(lst)

cnt=0


# for 문을 lst 의 레인지로 설정하면, lst의 요소가 빠질때 for문 자체가 돌지않는다.
# 그래서 while 문으로 조건을 걸어서 돌린다.
while lst_to_deque:
    if len(lst_to_deque) == 1:
        cnt+=1
        break
    
    if lst_to_deque[0]+lst_to_deque[-1] > safety_weight:
        lst_to_deque.pop()
        cnt+=1
    else:
        lst_to_deque.popleft()
        lst_to_deque.pop()
        cnt+=1
        
print(cnt)