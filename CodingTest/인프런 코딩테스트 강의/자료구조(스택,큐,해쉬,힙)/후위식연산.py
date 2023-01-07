post = "352+*9-"

stack = []

for i in post:
    if i.isdecimal():
        stack.append(int(i))
    elif i == "+":
        A=stack.pop()
        B=stack.pop()
        tmp = A+B
        stack.append(tmp)
    elif i == "*":
        A=stack.pop()
        B=stack.pop()
        tmp = A*B
        stack.append(tmp)
    elif i == "-":
        A=stack.pop()
        B=stack.pop()
        tmp = B-A
        stack.append(tmp)
    elif i == "/":
        A=stack.pop()
        B=stack.pop()
        tmp = A/B
        stack.append(tmp)
        
print(stack)

