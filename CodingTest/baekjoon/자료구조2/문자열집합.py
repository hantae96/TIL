import sys
#sys.stdin = open("/Users/Hantae/Desktop/Dev/TIL/CodingTest/baekjoon/자료구조2/input.txt")

n,m = map(int,input().split())
ans = 0
string = [input() for i in range(n)]

for i in range(m):
    if input() in string:
        ans+=1

print(ans)