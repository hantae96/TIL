from queue import PriorityQueue

import sys
sys.stdin = open("input.txt")

n = int(sys.stdin.readline().rstrip())

for _ in range(n):
    docs_count,num = map(int,sys.stdin.readline().rstrip().split())
    priority = list(map(int,sys.stdin.readline().rstrip().split()))

    que = PriorityQueue(maxsize = docs_count)
    count = 0
    for i in range(docs_count):
        tmp=que.put((-priority[i],i))

    for i in range(docs_count):
        tmp=que.get()
        count+=1
        if tmp[1] == num:
            print(count)
            break
    