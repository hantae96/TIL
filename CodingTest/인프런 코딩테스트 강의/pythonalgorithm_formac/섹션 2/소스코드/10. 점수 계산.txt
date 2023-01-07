import sys
sys.stdin=open("input.txt", "r")
n=int(input())
a=list(map(int, input().split()))
cnt=0
sum=0
for i in range(n):
    if a[i]==1:
        cnt=cnt+1
        sum=sum+cnt
    else:
        cnt=0

print(sum)