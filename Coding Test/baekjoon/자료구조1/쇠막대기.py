import sys
from collections import deque
sys.stdin = open("input.txt")
iron_bar = sys.stdin.readline().rstrip()

stack = []
answer = 0

for i in range(len(iron_bar)):
    if iron_bar[i] == "(":
        stack.append("(")
    elif iron_bar[i] == ")":
        stack.pop()
        answer += len(stack)

        
print(answer)
