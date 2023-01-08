import sys

def search(val,stack):
    flag = True

    for i in stack:
        if i != val:
            flag = False
    
    if flag:
        return True
    else:
        return False


sys.stdin = open("/Users/Hantae/Desktop/Dev/TIL/CodingTest/baekjoon/자료구조1/input.txt")
bracket = sys.stdin.readline().rstrip()


stack = []
result = 0
count1 = 0
count2 = 0

for idx,val in enumerate(bracket):
    if len(stack) == 0:
        if val == "]" or ")":
            print("NO")
            break
        else:
            stack.append(val)
    else:
        if search(val,stack):    
            if val == "(":
                stack.append("(")
            elif val == ")":
                count1+=2
            elif val == "[":
                stack.append("[")
            elif val == "]":
                count2+=3
        else:
            if val == "(":
                stack.append("(")
            elif val == ")":
                count1+=2
                result += count1*count2
                count1 = 0
            elif val == "[":
                stack.append("[")
            elif val == "]":
                
                count2+= 3
                result += count1*count2
                count2 = 0
            
print(bracket_1_count)