import sys
from collections import defaultdict

sys.stdin = open("/Users/Hantae/Desktop/Dev/TIL/CodingTest/baekjoon/자료구조2/input.txt")

n,m = map(int,sys.stdin.readline().split())
book = {}
name = []
for i in range(n):
    temp = sys.stdin.readline().rstrip()
    book[temp] = i+1
    name.append(temp)

for i in range(m):
    temp=sys.stdin.readline().rstrip()
    if temp.isdecimal():
        print(name[int(temp)-1])
    else:
        print(book[temp])        
    
