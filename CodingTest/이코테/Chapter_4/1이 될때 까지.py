import sys
sys.stdin=open("/Users/Hantae/Desktop/Programming/TIL/Coding Test/이코테/input.txt")

n,k = map(int,input().split())
count = 0

while True:
    big_number = (n//k)*k
    
    count += n - big_number
    n = big_number

    if n < k:
        break
    
    count +=1
    n = n//k

print(count-1)