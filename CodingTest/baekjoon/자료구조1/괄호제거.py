import sys
from itertools import combinations
sys.stdin = open("TIL/CodingTest/baekjoon/자료구조1/input.txt")

equation = list(input())

stack = []
index = []
result = set()

for i,val in enumerate(equation):
    if val == "(":
        equation[i] = ''
        index.append(i)
    if val == ")":
        equation[i] = ''
        stack.append([index.pop(),i])

print(equation)
print(stack)

for i in range(len(stack)):
    for j in combinations(stack,i):
        print(j)
        sample = equation[:]
        for start,end in j:
            sample[start] ='('
            sample[end] = ')'
        result.add(''.join(sample))

print(result)

    