from re import L
import sys

sys.stdin = open("input.txt","r")

arr = [list(map(int,input().split())) for _ in range(7)]

cnt = 0
## 행에서 펠린드롬
for i in range(len(arr)):
    for j in range(len(arr)-4):
        tmp = ""
        for k in range(5):
            tmp = tmp + str(arr[i][j+k])
        if tmp == tmp[::-1]:
            cnt+=1

## 열에서 펠린드롬 
for i in range(len(arr)):
    for j in range(len(arr)-4):
        tmp = ""
        for k in range(5):
            tmp = tmp + str(arr[j+k][i])
        if tmp == tmp[::-1]:
            cnt+=1


print(cnt)
    