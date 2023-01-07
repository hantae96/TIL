import sys
sys.stdin = open("input.txt","r")

N,M = map(int,input().split())
Music = list(map(int,input().split()))

def Counting(mid):
    tmp = 0
    cnt = 1
    for i in Music:
        if tmp+i <= mid:
            tmp += i
        else:
            tmp = i
            cnt+=1
    return cnt

lt = 1
rt = sum(Music)
res = 0

while lt <= rt:
    mid = (lt+rt)//2
    if Counting(mid) <= M:
        res = mid
        rt = mid- 1
    else:
        lt = mid +1
        
        
print(res)