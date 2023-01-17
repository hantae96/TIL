import sys
from heapq import heappush,heappop
sys.stdin = open("/Users/Hantae/Desktop/Dev/TIL/CodingTest/baekjoon/자료구조2/input.txt")

n = int(sys.stdin.readline().rstrip())
heap = []

for i in range(n):
    number = int(input())
    if number == 0 and len(heap) == 0:
        print(0)
    else:
        if number != 0:
            heappush(heap,(abs(number),number))
        if number == 0:
            print(heappop(heap)[1])
    
