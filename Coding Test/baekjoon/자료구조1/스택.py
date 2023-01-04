import sys
sys.stdin = open("input.txt")

n = int(input())

command_list = [input() for i in range(n)]
stack = []

for i in command_list:
    command=i.split()
    if command[0] == "push":
        stack.append(command[1])
    if command[0] == "top":
        if len(stack) == 0: print(-1)
        else : print(stack[-1])
    if command[0] == "size":
        print(len(stack))
    if command[0] == "empty":
        if len(stack) == 0:print(1)
        else: print(0)
    if command[0] == "pop":
        if len(stack) == 0:print(-1)
        else: print(stack.pop())
        