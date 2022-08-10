import sys
sys.stdin=open("input.txt", "r")
a=list(range(21))
for _ in range(10):
    s, e=map(int, input().split())
    for i in range((e-s+1)//2):
        a[s+i], a[e-i]=a[e-i], a[s+i]
a.pop(0)
for x in a:
    print(x, end=' ')