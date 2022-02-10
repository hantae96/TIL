N,M = 9,3
Music = [1,2,3,4,5,6,7,8,9]

def Counting(capacity):
    cnt = 1
    sum = 0
    for x in Music:
        if sum + x > capacity:
            cnt +=1
            sum =x
        else:
            sum +=x
    return cnt

left = 1
right = sum(Music)

while left <= right:
    mid=(left + right) // 2
    # Counting == 잘라본것을 용량이 맞는지 확인 하는 함수
    if Counting(mid) <= M:
        res=mid
    else:
        lt = mid +1
    
    print(res)
        
    