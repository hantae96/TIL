# input data

K,N = 4,11
arr = [802,743,457,539]

def Counting(mid):
    tmp = 0
    for i in arr:
        tmp+=i//mid
    return tmp



lt = 1
rt = max(arr)
res = 0

while lt<=rt:
    mid = (lt+rt)//2
    if Counting(mid) >= N:
        res = mid
        lt = mid+1
    else : 
        rt-=1
    

print(res)