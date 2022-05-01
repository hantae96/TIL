N,M = 9,3
Music = [1,2,3,4,5,6,7,8,9]

def Counting(capacity):
    cnt = 1
    sum = 0
    for x in Music:
        # 용량이 초과되면
        if sum + x > capacity:
            # 카운트를 증가하고
            cnt +=1
            # 새로운 곡을 sum에 넣고 초기화
            sum =x
        else:
            sum +=x
    return cnt

lt = 1
rt = sum(Music)

while lt <= rt:
    mid=(lt + rt) ## dvd 한장의 용량을 mid로
    # Counting == 잘라본것을 용량이 맞는지 확인 하는 함수
    # mid 정도로 하면 몇개가 나와??
    # 정확한 코드는 나중에 
    if Counting(mid) <= M:
        # res 보다 큰것은 무조껀 답이됨
        # 20을 넣을 수 있는 곳은 10도 넣을 수 있다.
        res=mid
        rt =mid -1 
    else:
        lt = mid +1
    
print(res)
        
    