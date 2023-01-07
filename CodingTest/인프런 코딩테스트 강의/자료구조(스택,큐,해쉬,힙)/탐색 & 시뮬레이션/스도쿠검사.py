import sys

sys.stdin = open("/Users/Hantae/Desktop/Programming/TIL/Coding Test/탐색 & 시뮬레이션/input.txt","r")

martix = []

for i in range(9):
    row = list(map(int,input().split()))
    martix.append(row)

flag = True

for i in range(len(martix)):
    for j in range(1,len(martix)):
        if j not in martix[i]:
            flag = False
            break
        
        if j not in martix[:][i]:
            flag = False
            break


lst = [0,3,6]

for i in lst:
    for j in lst:
        count = 0
        for k in range(3):
            for t in range(3):
                # print(f"({i+k}) ({j+t})")
                count+=martix[i+k][j+t]
        # print(count)
        if count != 45:
            flag= False

if flag:
    print("YES")
else:
    print("NO")
    