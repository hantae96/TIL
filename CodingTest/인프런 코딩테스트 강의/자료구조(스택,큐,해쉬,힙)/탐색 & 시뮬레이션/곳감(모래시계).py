import sys
from collections import deque
from operator import is_not
from functools import partial

sys.stdin = open("/Users/Hantae/Desktop/Programming/TIL/Coding Test/탐색 & 시뮬레이션/input.txt","r")
num1 = int(input())
arr1 = [list(map(int,input().split())) for _    in range(num1)]
arr1 = [i for i in arr1 if i is not None]

print(arr1)

num2 = int(input())
arr2 = [list(map(int,input().split())) for _ in range(num2)]

for i in arr2:
    row,direct,step = i
    target=deque(arr1[row])
    if direct == 0:
        step*=-1
    arr1[row]=target.rotate(step)

mid = num1//2
start = 0
end = num1
res = 0
print(arr1)

for i in range(num1):
    for j in range(start,end):
        res+=arr1[i][j]
    if i > num1 //2:
        start -=1
        end +=1
    else:
        start +=1
        end -=1

print(sum)