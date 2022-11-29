import sys
sys.stdin=open("Chapter_5/input.txt")

A,B = map(int,input().split())

start_x,start_y,direction = map(int,input().split())

martix = []

for _ in range(A):
    martix.append(list(map(int,input().split())))


print(martix)