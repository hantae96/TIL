import sys
from collections import deque

res = 0

n = int(input())

for i in range(n):
    string = deque(input())
    if len(string) < 3:
        if string[0] == string[1]:
            res+=1
            continue
    
    stack = []
    while string:
        if len(stack) == 0:
            stack.append(string.pop())
        else:
            end = string.pop()
            if end == stack[-1]:
                stack.pop()
            else:
                stack.append(end)
        
    if len(stack) == 0:
        res +=1
        

        

print(res)
