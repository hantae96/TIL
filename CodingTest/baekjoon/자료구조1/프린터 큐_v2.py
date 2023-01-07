import sys
import operator
from collections import deque

#sys.stdin = open("input.txt")

n = int(sys.stdin.readline().rstrip())


for _ in range(n):
    docs_count,num = map(int,sys.stdin.readline().rstrip().split())
    priority = list(map(int,sys.stdin.readline().rstrip().split()))
    que = deque()
    for i in range(docs_count):
        que.append((i,priority[i]))

    count = 1
    while True:
        elem = que[0]
        max_number = max(que, key=operator.itemgetter(1))
        if elem == max_number:
            if elem[0] == num:
                print(count)
                break
            else:
                que.popleft()
                count+=1
        else:
            tmp = que.popleft()
            que.append(tmp)

            