import sys
from collections import deque
# sys.stdin = open("input.txt")

n = int(input())

card = deque([i for i in range(n,0,-1)])
print(card)
# 스택의 맨 위를 버린다
# 그 후 제일 위에 있는 원소를 제일 처음으로 옮긴다.

while True:
    if len(card) == 1:
        break
    card.pop()
    tmp=card.pop()
    card.appendleft(tmp)

for i in card:
    print(i)