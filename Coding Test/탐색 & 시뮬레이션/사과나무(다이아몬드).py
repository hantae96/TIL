import sys
sys.stdin = open("/Users/Hantae/Desktop/Programming/TIL/Coding Test/탐색 & 시뮬레이션/input.txt","r")
n = int(input())
martix = [list(map(int,input().split())) for _ in range(n)]

mid = n//2

i = 1
res = 0

for idx,line in enumerate(martix[:mid]):
    if idx == 0:
       res+=line[mid]
    else:
        res+=sum(line[mid-i:mid+i+1])
        i+=1

i = mid-1
for idx,line in enumerate(martix[mid::]):
    if idx == 0:    
       res+=sum(line)
    else:
        res+=sum(line[mid-i:mid+i+1])
        i-=1

print(res)


start = end = n//2
for i in range(n):
    for j in range(start,end+1):
        res+=martix[i][j]
    if i < n //2:
        start -=1
        end +=1
    else:
        start +=1
        end -=1
