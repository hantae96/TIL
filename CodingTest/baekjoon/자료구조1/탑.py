import sys

sys.stdin = open("TIL/CodingTest/baekjoon/자료구조1/input.txt")
# 6 9 5 7 4

n = int(sys.stdin.readline())
tower = list(map(int,sys.stdin.readline().split()))
res = [0 for _ in range(n)]
stack = []


for i in range(len(tower)):
    now = tower[i]
    while stack and tower[stack[-1]] < now:
        stack.pop()
    
    if stack:
        res[i] = tower[i]
    stack.append(i)

print(res)
    