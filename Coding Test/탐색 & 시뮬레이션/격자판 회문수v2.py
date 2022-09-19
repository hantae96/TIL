import sys

sys.stdin = open("/Users/Hantae/Desktop/Programming/TIL/Coding Test/탐색 & 시뮬레이션/input.txt","r")
martix = []

def check1(martix,row,col):
    target = []
    flag = True
    for i in range(5):
        target.append(martix[row][col+i])
    for j in range(2):
        if target[j] != target[-(1+j)]:
            flag=False
            break

    
    if flag:
        return 1
    else:
        return 0


def check2(martix,row,col):
    target = []
    flag = True
    for i in range(5):
        target.append(martix[row+i][col])
    for j in range(2):
        if target[j] != target[-(1+j)]:
            flag=False
            break

    
    if flag:
        return 1
    else:
        return 0

res = 0

for i in range(7):
    row = list(map(int,input().split()))
    martix.append(row)

for i in range(len(martix)):
    for j in range(3):
        res+=check1(martix,i,j)

for j in range(len(martix)):
    for k in range(3):     
        res+=check2(martix,k,j)
print(res)