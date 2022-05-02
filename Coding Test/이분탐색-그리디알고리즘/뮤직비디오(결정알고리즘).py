N,M = 9,3
Music = [1,2,3,4,5,6,7,8,9]

def Counting(mid):
    tmp = 0
    cnt = 0
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