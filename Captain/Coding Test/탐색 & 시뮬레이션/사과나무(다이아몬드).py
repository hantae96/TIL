import sys
sys.stdin = open("input.txt","r")
n = int(input())
a = [list(map(int,input().split())) for _ in range(n)]

N = n//2

start = end = N
res = 0
for i in range(n):
    for j in range(start,end+1):
       res+=j
    if i > N:
        start-=1
        end+=1
    elif i <=N:
        start+=1
        end-=1

    