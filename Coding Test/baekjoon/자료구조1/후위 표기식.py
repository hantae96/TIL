import sys
sys.stdin = open("input.txt")

result = 0
n = int(sys.stdin.readline())
postfix = sys.stdin.readline().rstrip()
number = [0]*n

for i in range(n):
    number[i] = int(sys.stdin.readline())


stack = []

for i in postfix:
    if i.isalpha():
        stack.append(number[ord(i)-65])
    else:
        num2 =stack.pop()
        num1 =stack.pop()

        if i == "*":
            stack.append(num1*num2)
        elif i == "/":
            stack.append(num1/num2)
        elif i == "+":
            stack.append(num1+num2)
        elif i == "-":
            stack.append(num1-num2)
        
print(f"{stack[0]:.2f}")