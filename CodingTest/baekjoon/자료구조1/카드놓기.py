import sys

sys.stdin = open("/Users/Hantae/Desktop/Dev/TIL/CodingTest/baekjoon/자료구조1/input.txt")

#덱을 활용한 풀이

n = int(input())
array = list(map(int,input().split()))
origin = list(range(1,n+1))
res = []


# 순서대로 1,2,3,4,5 가 적혀있음
for i in range(len(array)):
    if array[i] == 1:
        res.append(origin[-(1+i)])
    elif array[i] == 2:
        res.append()
print(res)