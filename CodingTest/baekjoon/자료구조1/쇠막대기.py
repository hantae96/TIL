import sys
#sys.stdin = open("input.txt")
iron_bar = sys.stdin.readline().rstrip()


stack = []
answer = 0

for i in range(len(iron_bar)):
    if iron_bar[i] == "(":
        stack.append("(")
    elif iron_bar[i] == ")":
        if iron_bar[i-1] == "(":
            stack.pop()
            answer += len(stack)
        else:
            stack.pop()
            answer +=1
                
print(answer)
