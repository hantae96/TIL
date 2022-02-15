ex = "3+5*2/(7-2)"

inorder = []
for i in ex:
    inorder.append(i)
    
stack = []
prop = []
post = []

neworder = []

for i in range(len(inorder)):
    if inorder[i] == "(":
        j=i+1
        while inorder[j] != ")":
            prop.append(inorder[j])
            j+=1
    
for i in range(len(prop)):
    if prop[i].isdigit():
        neworder.append(prop[i])
    else:
        stack.append(prop[i])

# 우선순위 inorder 만듬
inorder = inorder[:-(len(prop)+2)] + (neworder + stack)

print(inorder)
# 스택 초기화
stack.clear()

for i in range(len(inorder)):
    if inorder[i].isdigit():
        post.append(inorder[i])
    else:
        if len(stack) == 0:
            stack.append(inorder[i])
        else:
            if inorder[i] == ("*" or "/"):
                
                if stack[-1] == ("*" or "/"):
                    
                    tmp=stack.pop()
                    print(f"{tmp}템프")
                    post.append(tmp)
                    stack.append(inorder[i])
                else:
                    stack.append(inorder[i])
            else:
                stack.append(inorder[i])
post=post + stack
print(post)