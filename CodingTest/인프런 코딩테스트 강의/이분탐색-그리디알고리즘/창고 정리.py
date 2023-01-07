L = 10
m = 50
arr = [69,42,68,76,40,87,14,65,76,81]

cnt=[0]*101
maxH=float('-inf')
minH=float('inf')
for x in arr:
    cnt[x]+=1 
    if x>maxH: maxH=x
    if x<minH: minH=x

for _ in range(m):
    if cnt[maxH]==1:
        cnt[maxH]-=1
        maxH-=1
        cnt[maxH]+=1
    else:
        cnt[maxH]-=1
        cnt[maxH-1]+=1

    if cnt[minH]==1:
        cnt[minH]-=1
        minH+=1
        cnt[minH]+=1
    else:
        cnt[minH]-=1
        cnt[minH+1]+=1
    
print(maxH-minH)