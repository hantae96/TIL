import sys

sys.stdin = open("Coding Test/자료구조(스택,큐,해쉬,힙)/input.txt","r")

N,M = map(int,input().split())
lst = list(map(int,input().split()))

count = 0
for i in range(N):
    sum = lst[i]
    j=i+1
    while N > j:
        sum += lst[j]
        if sum == M:
            count+=1
            break
        elif sum > M:
            break
        else:
            j+=1




print(count)
        