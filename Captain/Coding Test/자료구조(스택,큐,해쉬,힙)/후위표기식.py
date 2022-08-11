a = "3*(5+2)-9"
stack = []
res =""

for x in a:
    if x.isdigit():
        res+=x
    else:
        if x =="(":
            stack.append(x)
        elif x == "*" or x== "/":
            # 안에 * 나 /를 다 빼내고
            while stack and (stack[-1]=="*" or stack[-1]=="/"):
                res+=stack.pop()
            # 그 뒤에 추가
            stack.append(x)
        elif x== "+" or x=="-":
            # 여는 괄호 전까지만 
            while stack and stack[-1]!= "(":
                res+=stack.pop()
            stack.append(x)
        elif x==")":
            while stack and stack[-1]!="(":
                # 여는 괄호 제거
                res+=stack.pop()
            stack.pop()
                
while stack:
    res+=stack.pop()
    
print(res)