import sys
sys.stdin = open("input.txt")

n = int(input())
parenthesis_list = [input() for _ in range(n)]

for parenthesis in parenthesis_list:
    stack = []
    flag = True
    for i in parenthesis:
        if i == "(":
            stack.append("(")
        else : 
            if len(stack) == 0:
                flag = False
                break
            else:
                stack.pop()

    if flag and len(stack)==0:
        print("YES")
    else:
        print("NO")