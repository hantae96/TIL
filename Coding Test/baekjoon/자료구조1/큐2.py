import sys
from collections import deque
sys.stdin = open("input.txt")

n = int(sys.stdin.readline())


command_list = [sys.stdin.readline() for _ in range(n)]
stack = deque()

for i in command_list:
    command=i.split()
    if command[0] == "push":
        stack.append(command[1])
    if command[0] == "size":
        print(len(stack))
    if command[0] == "empty":
        if len(stack) == 0:print(1)
        else: print(0)
    if command[0] == "pop":
        if len(stack) == 0:print(-1)
        else: print(stack.popleft())
    if command[0] == "front":
        if len(stack) == 0: print(-1)
        else : print(stack[0])
    if command[0] == "back":
        if len(stack) == 0: print(-1)
        else : print(stack[-1])