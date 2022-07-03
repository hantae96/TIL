import sys
sys.stdin=open("input.txt", "r")
n=int(input())
meeting=[]
for i in range(n):
    a, b=map(int, input().split())
    meeting.append((a, b))
meeting.sort(key=lambda x : (x[1], x[0]))
et=0
cnt=0
for x, y in meeting:
    if x>=et:
        et=y
        cnt+=1
print(cnt)