import sys
sys.stdin=open("/Users/Hantae/Desktop/Programming/TIL/Coding Test/이코테/input.txt")
row,col = map(int,input().split())

result = 0
for i in range(row):
    data = list(map(int,input().split()))
    min_value = min(data)

    result = max(result,min_value)

print(result)