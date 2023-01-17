import sys
import heapq
sys.stdin = open("/Users/Hantae/Desktop/Dev/TIL/CodingTest/baekjoon/자료구조2/input.txt")

f = sys.stdin.readline
n = int(f())
total_list = []
for i in map(int, f().split()):
    heapq.heappush(total_list, i)

for i in range(1, n):
    a = list(map(int, f().split()))
    for j in range(n):
        if a[j] > total_list[0]:
            heapq.heappush(total_list, a[j])
            heapq.heappop(total_list)
print(total_list[0])